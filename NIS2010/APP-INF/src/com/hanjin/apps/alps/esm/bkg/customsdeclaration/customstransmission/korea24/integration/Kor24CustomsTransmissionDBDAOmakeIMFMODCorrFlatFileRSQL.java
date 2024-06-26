/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Kor24CustomsTransmissionDBDAOmakeIMFMODCorrFlatFileRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.13
*@LastModifier :
*@LastVersion : 1.0
* 2010.07.13
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Kor24CustomsTransmissionDBDAOmakeIMFMODCorrFlatFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * IMFMOD Correction Flat File
	  * </pre>
	  */
	public Kor24CustomsTransmissionDBDAOmakeIMFMODCorrFlatFileRSQL(){
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
		params.put("pre_ctnt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_ctnt1",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.integration").append("\n");
		query.append("FileName : Kor24CustomsTransmissionDBDAOmakeIMFMODCorrFlatFileRSQL").append("\n");
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
		query.append("    @[kr_cstms_corr_id]  ||'~'|| /*  정정항목 부호               */" ).append("\n");
		query.append("    @[corr_rsn]          ||'~'|| /*  정정사유 부호               */" ).append("\n");
		query.append("    BKG_SPCLCHAR_CONV_FNC(@[pre_ctnt1],'Y')  ||'~'|| /*  정정전 내역                 */" ).append("\n");
		query.append("    BKG_SPCLCHAR_CONV_FNC(@[pre_ctnt2],'Y')  ||'~'|| /*  정정전 내역 2               */" ).append("\n");
		query.append("    BKG_SPCLCHAR_CONV_FNC('','Y')  ||'~'|| /*  정정전 내역 3               */" ).append("\n");
		query.append("    BKG_SPCLCHAR_CONV_FNC('','Y')  ||'~'|| /*  정정전 내역 4               */" ).append("\n");
		query.append("    BKG_SPCLCHAR_CONV_FNC(@[crnt_ctnt1],'Y')  ||'~'|| /*  정정후 내역                 */" ).append("\n");
		query.append("    BKG_SPCLCHAR_CONV_FNC(@[crnt_ctnt2],'Y')  ||'~'|| /*  정정후 내역 2               */" ).append("\n");
		query.append("    BKG_SPCLCHAR_CONV_FNC('','Y')  ||'~'|| /*  정정후 내역 3               */" ).append("\n");
		query.append("    BKG_SPCLCHAR_CONV_FNC('','Y')  		   /*  정정후 내역 4               */" ).append("\n");
		query.append("FROM    DUAL" ).append("\n");

	}
}