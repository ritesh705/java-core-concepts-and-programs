package com.ritesh.ds.string;

import lombok.Data;

public final @Data class Immutable
{
	private final String name;
	private final String contact;

	private Immutable(String name, String contact)
	{
		this.name = name;
		this.contact = contact;
	}

	public static final Immutable createNewInstance(String name, String contact)
	{
		return new Immutable(name, contact);
	}
}
