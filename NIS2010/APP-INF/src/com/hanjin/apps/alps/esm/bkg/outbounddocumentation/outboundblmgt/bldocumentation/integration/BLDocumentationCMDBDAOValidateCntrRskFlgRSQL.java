/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BLDocumentationCMDBDAOValidateCntrRskFlgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.09
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2013.12.09 김태경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOValidateCntrRskFlgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BLDocumentationCMDBDAOValidateCntrRskFlgRSQL
	  * </pre>
	  */
	public BLDocumentationCMDBDAOValidateCntrRskFlgRSQL(){
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOValidateCntrRskFlgRSQL").append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y') " ).append("\n"); 
		query.append("SELECT MAX(CNT) AS CNT FROM (" ).append("\n"); 
		query.append("SELECT	count(1) CNT" ).append("\n"); 
		query.append("   FROM	BKG_VVD_HIS VVD" ).append("\n"); 
		query.append("  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	AND VVD.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("    AND	POD_CD IN " ).append("\n"); 
		query.append("   (SELECT	vps_port_cd --POD에 들리기 이전이라면" ).append("\n"); 
		query.append(" 	  FROM	vsk_vsl_port_skd" ).append("\n"); 
		query.append("	 WHERE	vsl_cd		= VVD.VSL_CD" ).append("\n"); 
		query.append("	   AND	skd_voy_no	= VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("	   AND	skd_dir_cd	= VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("	   AND	clpt_ind_seq= '1'" ).append("\n"); 
		query.append("	   AND	clpt_seq	>=" ).append("\n"); 
		query.append("		(SELECT	MIN(clpt_seq) --처음 CANADA를 들리는 port가" ).append("\n"); 
		query.append("	       FROM	vsk_vsl_port_skd" ).append("\n"); 
		query.append("		  WHERE	vsl_cd		= VVD.VSL_CD" ).append("\n"); 
		query.append("		    AND	skd_voy_no	= VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("		    AND	skd_dir_cd	= VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("		    AND	vps_port_cd	LIKE 'US%'" ).append("\n"); 
		query.append("		    AND	nvl(skd_cng_sts_cd, ' ') <> 'S'" ).append("\n"); 
		query.append("		    AND	clpt_seq	>= " ).append("\n"); 
		query.append("			(SELECT	MAX(clpt_seq) --출항 port 이후에" ).append("\n"); 
		query.append("			   FROM	vsk_vsl_port_skd" ).append("\n"); 
		query.append("			  WHERE	vsl_cd		= VVD.VSL_CD" ).append("\n"); 
		query.append("			    AND	skd_voy_no	= VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("			    AND	skd_dir_cd	= VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("			    AND	vps_port_cd	LIKE VVD.POL_CD " ).append("\n"); 
		query.append("		        AND	nvl(skd_cng_sts_cd, ' ') <> 'S') ) )" ).append("\n"); 
		query.append("   AND SUBSTR(VVD.POL_CD, 1, 2) <> 'CA'--POL이 미국일 때는 제외" ).append("\n"); 
		query.append("   AND SUBSTR(VVD.POL_CD, 1, 2) <> 'US'--POL이 CANADA일 때는 제외" ).append("\n"); 
		query.append("   AND SUBSTR(VVD.POD_CD, 1, 2) <> 'US'--POD가 CANADA일 때는 제외" ).append("\n"); 
		query.append("   AND NOT EXISTS (SELECT 'Y' FROM BKG_CNTR_HIS WHERE BKG_NO = VVD.BKG_NO AND CNTR_NO = @[cntr_no] AND CORR_NO = 'TMP0000001' AND ROWNUM = 1 )" ).append("\n"); 
		query.append("   UNION" ).append("\n"); 
		query.append("      SELECT COUNT(1) CNT FROM BKG_BKG_HIS BK" ).append("\n"); 
		query.append("   WHERE 1=1" ).append("\n"); 
		query.append("     AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	 AND BK.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("     AND (POD_CD LIKE 'US%' OR POD_CD LIKE 'CA%')" ).append("\n"); 
		query.append("#if (${rc_flg} == 'Y') " ).append("\n"); 
		query.append("     AND NOT EXISTS (SELECT 'Y' FROM BKG_RF_CGO WHERE BKG_NO = BK.BKG_NO AND CNTR_NO = @[cntr_no] AND CORR_NO = 'TMP0000001' AND ROWNUM = 1 )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("     AND NOT EXISTS (SELECT 'Y' FROM BKG_CNTR_HIS WHERE BKG_NO = BK.BKG_NO AND CNTR_NO = @[cntr_no] AND CORR_NO = 'TMP0000001' AND ROWNUM = 1 )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") DUAL" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("SELECT MAX(CNT) AS CNT FROM (" ).append("\n"); 
		query.append("SELECT	count(1) CNT" ).append("\n"); 
		query.append("   FROM	BKG_VVD VVD" ).append("\n"); 
		query.append("  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("    AND	POD_CD IN " ).append("\n"); 
		query.append("   (SELECT	vps_port_cd --POD에 들리기 이전이라면" ).append("\n"); 
		query.append(" 	  FROM	vsk_vsl_port_skd" ).append("\n"); 
		query.append("	 WHERE	vsl_cd		= VVD.VSL_CD" ).append("\n"); 
		query.append("	   AND	skd_voy_no	= VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("	   AND	skd_dir_cd	= VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("	   AND	clpt_ind_seq= '1'" ).append("\n"); 
		query.append("	   AND	clpt_seq	>=" ).append("\n"); 
		query.append("		(SELECT	MIN(clpt_seq) --처음 CANADA를 들리는 port가" ).append("\n"); 
		query.append("	       FROM	vsk_vsl_port_skd" ).append("\n"); 
		query.append("		  WHERE	vsl_cd		= VVD.VSL_CD" ).append("\n"); 
		query.append("		    AND	skd_voy_no	= VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("		    AND	skd_dir_cd	= VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("		    AND	vps_port_cd	LIKE 'US%'" ).append("\n"); 
		query.append("		    AND	nvl(skd_cng_sts_cd, ' ') <> 'S'" ).append("\n"); 
		query.append("		    AND	clpt_seq	>= " ).append("\n"); 
		query.append("			(SELECT	MAX(clpt_seq) --출항 port 이후에" ).append("\n"); 
		query.append("			   FROM	vsk_vsl_port_skd" ).append("\n"); 
		query.append("			  WHERE	vsl_cd		= VVD.VSL_CD" ).append("\n"); 
		query.append("			    AND	skd_voy_no	= VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("			    AND	skd_dir_cd	= VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("			    AND	vps_port_cd	LIKE VVD.POL_CD " ).append("\n"); 
		query.append("		        AND	nvl(skd_cng_sts_cd, ' ') <> 'S') ) )" ).append("\n"); 
		query.append("   AND SUBSTR(VVD.POL_CD, 1, 2) <> 'CA'--POL이 미국일 때는 제외" ).append("\n"); 
		query.append("   AND SUBSTR(VVD.POL_CD, 1, 2) <> 'US'--POL이 CANADA일 때는 제외" ).append("\n"); 
		query.append("   AND SUBSTR(VVD.POD_CD, 1, 2) <> 'US'--POD가 CANADA일 때는 제외" ).append("\n"); 
		query.append("   AND NOT EXISTS (SELECT 'Y' FROM BKG_CONTAINER WHERE BKG_NO = VVD.BKG_NO AND CNTR_NO = @[cntr_no] AND ROWNUM = 1 )" ).append("\n"); 
		query.append("   UNION" ).append("\n"); 
		query.append("      SELECT COUNT(1) CNT FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("   WHERE 1=1" ).append("\n"); 
		query.append("     AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     AND (POD_CD LIKE 'US%' OR POD_CD LIKE 'CA%')" ).append("\n"); 
		query.append("#if (${rc_flg} == 'Y') " ).append("\n"); 
		query.append("     AND NOT EXISTS (SELECT 'Y' FROM BKG_RF_CGO WHERE BKG_NO = BK.BKG_NO AND CNTR_NO = @[cntr_no] AND ROWNUM = 1 )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	 AND NOT EXISTS (SELECT 'Y' FROM BKG_CONTAINER WHERE BKG_NO = BK.BKG_NO AND CNTR_NO = @[cntr_no] AND ROWNUM = 1 )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") DUAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}