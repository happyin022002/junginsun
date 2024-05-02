/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : KoreaCustomsReportDBDAOsearchOFMListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KoreaCustomsReportDBDAOsearchOFMListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OFM List 조회
	  * </pre>
	  */
	public KoreaCustomsReportDBDAOsearchOFMListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mf_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_bl_ts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.integration").append("\n"); 
		query.append("FileName : KoreaCustomsReportDBDAOsearchOFMListRSQL").append("\n"); 
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
		query.append("SELECT NVL(MSN.BKG_NO, ' ') BKG_NO ," ).append("\n"); 
		query.append("       NVL(BKG.BL_NO, ' ') BL_NO ," ).append("\n"); 
		query.append("       NVL(MSN.MRN_BL_TS_CD, ' ') MRN_BL_TS_CD ," ).append("\n"); 
		query.append("       NVL(VVD.POL_CD, ' ') POL_CD ," ).append("\n"); 
		query.append("       NVL(VVD.POD_CD, ' ') POD_CD ," ).append("\n"); 
		query.append("       NVL(MSN.KR_CSTMS_BL_TP_CD, ' ') KR_CSTMS_BL_TP_CD ," ).append("\n"); 
		query.append("       DECODE(@[io_bnd_cd], 'O', NVL(BKG.KR_CSTMS_CUST_TP_CD, 'N'), NVL(MSN.KR_CSTMS_BL_TP_CD, 'N')) BL_TP ," ).append("\n"); 
		query.append("       NVL(BKG.POD_CD, ' ') FNL_POD_CD ," ).append("\n"); 
		query.append("       DOC.CSTMS_DESC ," ).append("\n"); 
		query.append("       VVPS.OB_CSSM_VOY_NO" ).append("\n"); 
		query.append("  FROM BKG_VVD VVD," ).append("\n"); 
		query.append("       BKG_BOOKING BKG," ).append("\n"); 
		query.append("       BKG_BL_DOC DOC," ).append("\n"); 
		query.append("       BKG_CSTMS_KR_MF_SEQ_NO MSN," ).append("\n"); 
		query.append("       VSK_VSL_PORT_SKD VVPS" ).append("\n"); 
		query.append(" WHERE VVD.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("   AND VVD.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND VVD.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND VVD.POL_CD = @[port_cd]" ).append("\n"); 
		query.append("   AND VVD.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = MSN.BKG_NO" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = DOC.BKG_NO" ).append("\n"); 
		query.append("   AND MSN.MF_REF_NO = @[mf_ref_no] " ).append("\n"); 
		query.append("#if(${mrn_bl_ts_cd} != '')" ).append("\n"); 
		query.append("   AND MSN.MRN_BL_TS_CD LIKE @[mrn_bl_ts_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND VVD.VSL_CD = VVPS.VSL_CD(+)" ).append("\n"); 
		query.append("   AND VVD.SKD_VOY_NO = VVPS.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND VVD.SKD_DIR_CD = VVPS.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND VVD.POL_CD = VVPS.VPS_PORT_CD(+)" ).append("\n"); 
		query.append(" ORDER BY MSN.MRN_BL_TS_CD," ).append("\n"); 
		query.append("       VVD.POD_CD" ).append("\n"); 

	}
}