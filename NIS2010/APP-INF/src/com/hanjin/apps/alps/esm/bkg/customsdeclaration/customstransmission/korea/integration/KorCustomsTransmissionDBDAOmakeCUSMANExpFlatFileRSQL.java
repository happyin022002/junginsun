/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : KorCustomsTransmissionDBDAOmakeCUSMANExpFlatFileRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorCustomsTransmissionDBDAOmakeCUSMANExpFlatFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CUSMAN 의 Export Lic 정보에 대한 Flat file을 만든다.
	  * </pre>
	  */
	public KorCustomsTransmissionDBDAOmakeCUSMANExpFlatFileRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.integration").append("\n"); 
		query.append("FileName : KorCustomsTransmissionDBDAOmakeCUSMANExpFlatFileRSQL").append("\n"); 
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
		query.append("        REPLACE(KE.XPT_LIC_NO, '-', '') ||'~'|| /*  Export License No   */" ).append("\n"); 
		query.append("        BME.UCR_NO    ||'~'|| /*  UCR No              */" ).append("\n"); 
		query.append("        KE.PCK_TP_CD  ||'~'|| /*  Package Unit        */" ).append("\n"); 
		query.append("        KE.PCK_QTY    ||'~'|| /*  Package Count       */" ).append("\n"); 
		query.append("        KE.WGT_UT_CD  ||'~'|| /*  Weight Unit         */" ).append("\n"); 
		query.append("        TRIM(TO_CHAR(KE.CNTR_WGT,'999999999999999.999'))||'~'|| /*  Weight              */" ).append("\n"); 
		query.append("        KE.PRT_LODG_FLG    ||'~'|| /*  분할선적 여부       */" ).append("\n"); 
		query.append("        KE.PRT_LODG_SEQ    ||'~'|| /*  This E/L No         */" ).append("\n"); 
		query.append("        KE.KR_XPT_PCK_ID   ||'~'|| /*  동시 포장 여부      */" ).append("\n"); 
		query.append("        KE.DIVD_PCK_UT_CD  ||'~'|| /*  Unit Pakage Unit    */" ).append("\n"); 
		query.append("        KE.DIVD_PCK_QTY    ||'~'   /*  Unit Package Count  */" ).append("\n"); 
		query.append("        ), 7) EL_DATA" ).append("\n"); 
		query.append("FROM    BKG_CSTMS_KR_XPT_LIC KE, BKG_XPT_IMP_LIC BME" ).append("\n"); 
		query.append("WHERE   KE.BKG_NO           =   @[bkg_no]" ).append("\n"); 
		query.append("AND     KE.BKG_NO           =   BME.BKG_NO(+)" ).append("\n"); 
		query.append("AND     KE.CSTMS_DECL_TP_CD =   @[cstms_decl_tp_cd]" ).append("\n"); 
		query.append("AND     KE.DMST_PORT_CD     =   @[port_cd]" ).append("\n"); 
		query.append("AND	    KE.TRNS_SEQ = (SELECT MAX(TRNS_SEQ)" ).append("\n"); 
		query.append("                                 FROM   BKG_CSTMS_KR_BL" ).append("\n"); 
		query.append("                                 WHERE  BKG_NO           = @[bkg_no]" ).append("\n"); 
		query.append("                                 AND    CSTMS_DECL_TP_CD = @[cstms_decl_tp_cd]" ).append("\n"); 
		query.append("                                 AND    DMST_PORT_CD     = @[port_cd]" ).append("\n"); 
		query.append("                                 AND    VSL_CD           = substr(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                                 AND    SKD_VOY_NO       = substr(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                                 AND    SKD_DIR_CD       = substr(@[vvd], 9, 1))" ).append("\n"); 
		query.append("GROUP BY KE.XPT_LIC_NO" ).append("\n"); 

	}
}