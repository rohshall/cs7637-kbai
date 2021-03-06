package project2;

import java.util.ArrayList;
import java.util.List;

public class IfEqual implements Antecedent
{
	private List<Integer> values = new ArrayList<Integer>();
	private String antecedentKey;
	
	public IfEqual(String antecedentKey, int[] values)
	{
		for (int v : values)
		{
			this.values.add(v);
		}
		this.antecedentKey = antecedentKey;
	}

	public IfEqual(String antecedentKey, List<Integer> values)
	{
		this.values.addAll(values);
		this.antecedentKey = antecedentKey;
	}

	public IfEqual(String antecedentKey, int value)
	{
		this.values.add(value);
		this.antecedentKey = antecedentKey;
	}
	
	@Override
	public boolean applies(Context context)
	{
		final Object value = context.get(this.antecedentKey);

		if (value == null)
		{
			return false;
		}

		// allow integers as strings 
		if (value instanceof String)
		{
			int valueInt = Integer.parseInt((String)value);
			return values.contains(valueInt);
		}

		// add other type support here

		// do not bother with any other type you do not expect
		if (!(value instanceof Integer))
		{
			return false;
		}

		return values.contains(value);
	}
}
