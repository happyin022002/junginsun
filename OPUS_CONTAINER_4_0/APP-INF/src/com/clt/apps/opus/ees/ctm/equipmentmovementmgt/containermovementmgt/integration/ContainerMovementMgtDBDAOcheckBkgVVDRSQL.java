/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOcheckBkgVVDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.30
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOcheckBkgVVDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG NO 와 POL POD에 대하여 (Vl, VD) VVD가 존재하는지 검증한다
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOcheckBkgVVDRSQL(){
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
		params.put("crnt_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOcheckBkgVVDRSQL").append("\n"); 
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
		query.append("SELECT 'A' CN" ).append("\n"); 
		query.append("#if (${osca_bkg_flg} == 'Y')" ).append("\n"); 
		query.append("  FROM CTM_BKG_VVD BV" ).append("\n"); 
		query.append("      ,CTM_BOOKING BO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  FROM BKG_VVD BV" ).append("\n"); 
		query.append("      ,BKG_BOOKING BO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE BV.BKG_NO = BO.BKG_NO" ).append("\n"); 
		query.append("   AND (BO.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("        OR (BO.HCMT_CMB_FLG = 'Y' AND BO.TO_BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#if (${crnt_vsl_cd}) " ).append("\n"); 
		query.append("   AND BV.VSL_CD = @[crnt_vsl_cd]" ).append("\n"); 
		query.append("   AND BV.SKD_VOY_NO = @[crnt_skd_voy_no]" ).append("\n"); 
		query.append("   AND BV.SKD_DIR_CD = @[crnt_skd_dir_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND BV.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("   AND BV.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND BV.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("   AND BV.POL_CD = SUBSTR(@[pol_cd], 0, 5)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("   AND BV.POD_CD = SUBSTR(@[pod_cd],0,5)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}