/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorCustomsTransmissionDBDAOMakeFlatFileBLBodyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.07.06 손윤석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Son Yun Seuk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorCustomsTransmissionDBDAOMakeFlatFileBLBodyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MakeFlatFileBLBody
	  * </pre>
	  */
	public KorCustomsTransmissionDBDAOMakeFlatFileBLBodyRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_loc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_loc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kt_port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT KT.BKG_NO" ).append("\n"); 
		query.append(", KT.CSTMS_DECL_TP_CD KCD_TP" ).append("\n"); 
		query.append(", SUBSTR(" ).append("\n"); 
		query.append("MAX(TO_CHAR(KT.TRNS_SEQ, '00000')||" ).append("\n"); 
		query.append("'{BL_CNTR'          ||CHR(10)||                    /* Start of B/L Info. Block */" ).append("\n"); 
		query.append("'BLNBR:'            ||KT.BL_NO||CHR(10)||          /* BL NO */" ).append("\n"); 
		query.append("'T_REF_NO:'         ||KT.MST_BL_SEQ_NO ||CHR(10)|| /* MSN */" ).append("\n"); 
		query.append("'BOND_AREA_CODE:'   ||KT.BD_AREA_CD ||CHR(10)||    /* BOND_AREAR_CODE */" ).append("\n"); 
		query.append("'PKG:'              ||KT.PCK_QTY ||CHR(10)||       /* Pakage Count */" ).append("\n"); 
		query.append("'PKGU:'             ||KT.PCK_TP_CD ||CHR(10)||     /* Pakage Unit */" ).append("\n"); 
		query.append("'WGT:'              ||KT.CNTR_TTL_WGT ||CHR(10)    /* Weight */" ).append("\n"); 
		query.append("), 7) BL_DATA" ).append("\n"); 
		query.append("FROM BKG_CSTMS_KR_BL KT" ).append("\n"); 
		query.append("WHERE (KT.BKG_NO, KT.CSTMS_DECL_TP_CD, KT.DMST_PORT_CD, KT.TRNS_SEQ)" ).append("\n"); 
		query.append("IN ( SELECT BKG_NO, CSTMS_DECL_TP_CD, DMST_PORT_CD, MAX(TRNS_SEQ)" ).append("\n"); 
		query.append("FROM BKG_CSTMS_KR_BL" ).append("\n"); 
		query.append("WHERE VSL_CD = SUBSTR(@[vsl_cd], 1, 4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[vsl_cd], 5, 4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[vsl_cd], 9, 1)" ).append("\n"); 
		query.append("AND DMST_PORT_CD = @[kt_port]" ).append("\n"); 
		query.append("AND KR_CSTMS_BND_CD = @[ob_type]" ).append("\n"); 
		query.append("AND DECODE(@[mrn_type], 'I', CSTMS_DECL_TP_CD, 'I') IN ('I', 'T')" ).append("\n"); 
		query.append("AND DECODE(@[mrn_type], 'O', CSTMS_DECL_TP_CD, 'E') IN ('E', 'R')" ).append("\n"); 
		query.append("AND DECODE(@[mrn_type], 'I', TS_POD_CD, TS_POL_CD)" ).append("\n"); 
		query.append("= DECODE(@[mrn_type], 'I', @[pod_loc], @[pol_loc])" ).append("\n"); 
		query.append("GROUP BY BKG_NO, CSTMS_DECL_TP_CD, DMST_PORT_CD" ).append("\n"); 
		query.append("HAVING SUBSTR(MAX(TO_CHAR(TRNS_SEQ, '00')||NVL(DELT_FLG, 'N')), 4) != 'Y'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND NVL(KT.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("GROUP BY KT.BKG_NO, KT.CSTMS_DECL_TP_CD" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.esm.bkg.customsdeclaration.customstransmission.korea.integration").append("\n"); 
		query.append("FileName : KorCustomsTransmissionDBDAOMakeFlatFileBLBodyRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}