�}6\  }  �4Z`ߴ��    ��ֻ�i�.Jp�"&�8��t	C���Ӆ���g�',��(�v���&�d�,�^����.h��d��%d�&kuv�P5*��#����>��\h�' d�����&�a�n�byL�5�#fW���4F�������= ���T���%g�qc�G��N:���V� Q@��O��O����Qe������
_f�ɂ/��u�<��4�QT`�s��*CN�J�ʭ����q�<we�&��˖�Mn�h{Q&���5m4��t_r�I1oT�-��-��s���ڹp�],�x��h�<aC��5��6���yOo<79r�f��E9��dȴePVE=0��&kD�w��2GՄ���*;�K��N�����|۰)��lkcw���#���w���'yvjZ��Ǫf��a>�ģ6���[P��A&�9�m�%�w� ۲��/\^����Ҋ�J~/���$�9JV7����I#��(��l�/���~ �P�R����ؤw'\��q��/�`��}�}k!/�����wh��Nv�0�i�d��-�0�)�[-C&�z�2���1�6�qQW �o�Έ>w��(�U{	wv��m+]�w}��P�3�wyI.ucƂ�X�^������3M�Q��}�-����yV�r�ن��Do�*�AzS���xAT�#-�񺑁̥&և�wJ�aɭ��hsk�(���6��QG(�%~t5ms�`�r�h�y�U�KY���錶��_��\E=�<���ḝ���gg������w��M_ �(�g�/E��?�y^7*���u��G54�AG��A�d���P`���!��T��j}��P�@�*�0��?{�"�a�.��Fhրb�q�H�ք� ��>��[�9PI��!m��S�L+����Y��Hs�Hr��� naL,���n�0'�K��a��#Z�j>��rh�u�(�\�6��wv���q6��*rҰh˗fUF)q����`&
���}�>KString, String> tags, byte[] arg4) {
		producer.publish(metric, timestamp, value, tags);
		return new Deferred<Object>();
	}

	@Override
	public Deferred<Object> shutdown() {
		// TODO Auto-generated method stub
		return new Deferred<Object>();
	}

	@Override
	public String version() {
		// TODO Auto-generated method stub
		return "2.1.0";
	}

	@Override
	public Deferred<Object> publishAnnotation(Annotation arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
