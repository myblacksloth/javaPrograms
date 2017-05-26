public class StructIterator implements HashSetIterator
	{
		//variabili d'istanza
		Node current, previous;
		int bucket, previousBucket;
		
		//costruttore
		public StructIterator()
		{
			this.current = null;
			this.previous = null;
			this.bucket = -1;
			this.previousBucket = -1;
		}
		
		@Override
		public boolean hasNext()
		{
			if (current != null && currentre.link != null)
			return true;
			
			//il for andra' effettivamente da buckets[0] a buckets[end-1]
			for (int i=bucket+1; i<buckets.length; i++)
				if (buckets[i] != null)
					return true;
			
			return false;
		}
		
		@Override
		public House next()
		{
			previous = current;
			previousBucket = bucket;
			
			if (current==null || current.link==null)
			{
				bucket++;
				
				while (bucket<buckets.length && buckets[bucket]==null)
					bucket++;
				
				if (bucket!=buckets.length)
					current = buckets[bucket];
				else
					throw new NoSuchElementException();
			}
			
			return current.house;
		}
		
		@Override
		public void remove()
		{
			if (previous!=null && previous.link==current)
				previous.link = current.link;
			else if(previousBucket < bucket)
				buckets[bucket] = current.link;
			else
				throw new NoSuchElementException();
			
			current = previous;
			bucket = previousBucket;
		}
		
	} //end of iterator's class
