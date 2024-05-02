/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KorCustomsTransmissionDBDAOmakeAutoIMFMODCorrFlatFileRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.14
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.01.14 박상훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorCustomsTransmissionDBDAOmakeAutoIMFMODCorrFlatFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 단일항목 정정 Info Flat Creation
	  * </pre>
	  */
	public KorCustomsTransmissionDBDAOmakeAutoIMFMODCorrFlatFileRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.integration ").append("\n");
		query.append("FileName : KorCustomsTransmissionDBDAOmakeAutoIMFMODCorrFlatFileRSQL").append("\n");
		query.append("*/").append("\n");
	}

	public String getSQL(){
		return query.toString();
	}

	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT" ).append("\n");
		query.append("'{UNIT_MODI'            ||'~'|| /*  Start of MODI Block         */" ).append("\n");
		query.append("'MODI_CORR_CD:' ||'BM'  ||'~'|| /*  정정항목 부호               */" ).append("\n");
		query.append("'MODI_CORR_RSCD:'||'14' ||'~'|| /*  정정사유 부호(14.통과(t/s)화물을 수입화물로 잘못기재한 경우)  */" ).append("\n");
		query.append("'MODI_PRE_TXT1:'||'I'   ||'~'||     /*  정정전 내역                 */" ).append("\n");
		query.append("'MODI_PRE_TXT2:'||''    ||'~'||     /*  정정전 내역 2               */" ).append("\n");
		query.append("'MODI_PRE_TXT3:'||''    ||'~'||     /*  정정전 내역 3               */" ).append("\n");
		query.append("'MODI_PRE_TXT4:'||''    ||'~'||     /*  정정전 내역 4               */" ).append("\n");
		query.append("'MODI_TXT1:'    ||'T'   ||'~'||     /*  정정후 내역                 */" ).append("\n");
		query.append("'MODI_TXT2:'    ||''    ||'~'||     /*  정정후 내역 2               */" ).append("\n");
		query.append("'MODI_TXT3:'    ||''    ||'~'||     /*  정정후 내역 3               */" ).append("\n");
		query.append("'MODI_TXT4:'    ||''    ||'~'||     /*  정정후 내역 4               */" ).append("\n");
		query.append("'}UNIT_MODI'" ).append("\n");
		query.append("FROM    DUAL" ).append("\n");

	}
}