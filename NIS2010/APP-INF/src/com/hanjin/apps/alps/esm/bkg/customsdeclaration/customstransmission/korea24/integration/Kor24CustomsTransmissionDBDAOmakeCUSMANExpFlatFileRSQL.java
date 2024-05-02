/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : Kor24CustomsTransmissionDBDAOmakeCUSMANExpFlatFileRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.04
*@LastModifier :
*@LastVersion : 1.0
* 2012.12.04
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

public class Kor24CustomsTransmissionDBDAOmakeCUSMANExpFlatFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * CUSMAN 의 Export Lic 정보에 대한 Flat file을 만든다.
	  * </pre>
	  */
	public Kor24CustomsTransmissionDBDAOmakeCUSMANExpFlatFileRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_decl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.integration").append("\n");
		query.append("FileName : Kor24CustomsTransmissionDBDAOmakeCUSMANExpFlatFileRSQL").append("\n");
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
		query.append("SELECT  SUBSTR(MAX(TO_CHAR(KE.TRNS_SEQ, '00000')||" ).append("\n");
		query.append("REPLACE(KE.XPT_LIC_NO, '-', '') ||'~'|| /*  Export License No   */" ).append("\n");
		query.append("BME.UCR_NO    ||'~'|| /*  UCR No              */" ).append("\n");
		query.append("KE.PCK_TP_CD  ||'~'|| /*  Package Unit        */" ).append("\n");
		query.append("KE.PCK_QTY    ||'~'|| /*  Package Count       */" ).append("\n");
		query.append("KE.WGT_UT_CD  ||'~'|| /*  Weight Unit         */" ).append("\n");
		query.append("TRIM(TO_CHAR(KE.CNTR_WGT,'999999999999999.99'))||'~'|| /*  Weight              */" ).append("\n");
		query.append("KE.PRT_LODG_FLG    ||'~'|| /*  분할선적 여부       */" ).append("\n");
		query.append("KE.PRT_LODG_SEQ    ||'~'|| /*  This E/L No         */" ).append("\n");
		query.append("KE.KR_XPT_PCK_ID   ||'~'|| /*  동시 포장 여부      */" ).append("\n");
		query.append("KE.DIVD_PCK_UT_CD  ||'~'|| /*  Unit Pakage Unit    */" ).append("\n");
		query.append("KE.DIVD_PCK_QTY    ||'~'   /*  Unit Package Count  */" ).append("\n");
		query.append("), 7) EL_DATA" ).append("\n");
		query.append("FROM    BKG_CSTMS_ADV_KR_XPT_LIC KE, BKG_XPT_IMP_LIC BME" ).append("\n");
		query.append("WHERE   KE.BKG_NO           =   @[bkg_no]" ).append("\n");
		query.append("AND     KE.BKG_NO           =   BME.BKG_NO(+)" ).append("\n");
		query.append("AND     KE.CSTMS_DECL_TP_CD =   @[cstms_decl_tp_cd]" ).append("\n");
		query.append("AND     KE.DMST_PORT_CD     =   @[port_cd]" ).append("\n");
		query.append("GROUP BY KE.XPT_LIC_NO" ).append("\n");

	}
}