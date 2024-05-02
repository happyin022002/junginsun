/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KorCustomsTransmissionDBDAOmakeCUSMODBlCorrFlatFileRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.13
*@LastModifier :
*@LastVersion : 1.0
* 2010.07.13
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorCustomsTransmissionDBDAOmakeCUSMODBlCorrFlatFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * CUSMOD BL Info Correction Flat File
	  * </pre>
	  */
	public KorCustomsTransmissionDBDAOmakeCUSMODBlCorrFlatFileRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kr_cstms_corr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("corr_rsn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_ctnt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_ctnt1",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.integration").append("\n");
		query.append("FileName : KorCustomsTransmissionDBDAOmakeCUSMODBlCorrFlatFileRSQL").append("\n");
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
		query.append("SELECT  @[kr_cstms_corr_id]			         		||'~'|| /*  정정항목 부호           */" ).append("\n");
		query.append("    	BKG_SPCLCHAR_CONV_FNC(@[crnt_ctnt1],'Y')  	||'~'|| /*  정정후 내역1     */" ).append("\n");
		query.append("    	BKG_SPCLCHAR_CONV_FNC(@[crnt_ctnt2],'Y')  	||'~'|| /*  정정후 내역2     */" ).append("\n");
		query.append("    	BKG_SPCLCHAR_CONV_FNC('','Y')  				||'~'|| /*  정정후 내역3     */" ).append("\n");
		query.append("    	''                    						||'~'|| /*  정정후 내역4     */" ).append("\n");
		query.append("    	@[corr_rsn]      									/*  정정 이유                     */" ).append("\n");
		query.append("FROM DUAL" ).append("\n");

	}
}