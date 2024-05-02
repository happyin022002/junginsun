/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ContainerMovementFinderDBDAOAddManageVVDListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.31
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.31 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementFinderDBDAOAddManageVVDListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Insert
	  * </pre>
	  */
	public ContainerMovementFinderDBDAOAddManageVVDListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("vsl_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_pre_pst_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementFinderDBDAOAddManageVVDListCSQL").append("\n"); 
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
		query.append("INSERT INTO CTM_BKG_VVD" ).append("\n"); 
		query.append("            (BKG_NO," ).append("\n"); 
		query.append("            VSL_PRE_PST_CD," ).append("\n"); 
		query.append("            VSL_SEQ," ).append("\n"); 
		query.append("            SLAN_CD," ).append("\n"); 
		query.append("            VSL_CD," ).append("\n"); 
		query.append("            SKD_VOY_NO," ).append("\n"); 
		query.append("            SKD_DIR_CD," ).append("\n"); 
		query.append("            POL_CD," ).append("\n"); 
		query.append("            POL_YD_CD," ).append("\n"); 
		query.append("            POD_CD," ).append("\n"); 
		query.append("            POD_YD_CD," ).append("\n"); 
		query.append("            CRE_USR_ID," ).append("\n"); 
		query.append("            CRE_DT," ).append("\n"); 
		query.append("            UPD_USR_ID," ).append("\n"); 
		query.append("            UPD_DT," ).append("\n"); 
		query.append("            POL_CLPT_IND_SEQ," ).append("\n"); 
		query.append("            POD_CLPT_IND_SEQ)" ).append("\n"); 
		query.append("VALUES (@[bkg_no]," ).append("\n"); 
		query.append("        DECODE(@[vsl_pre_pst_cd], 'PRE', 'S', 'TRUNK', 'T', 'POST', 'U', 'T')," ).append("\n"); 
		query.append("        NVL(@[vsl_seq],1)," ).append("\n"); 
		query.append("        NVL(@[slan_cd],'')," ).append("\n"); 
		query.append("        SUBSTR(@[vvd], 1,4)," ).append("\n"); 
		query.append("        SUBSTR(@[vvd], 5,4)," ).append("\n"); 
		query.append("        SUBSTR(@[vvd], 9,1)," ).append("\n"); 
		query.append("        SUBSTR(@[pol_cd], 1,5)," ).append("\n"); 
		query.append("        @[pol_cd]," ).append("\n"); 
		query.append("        SUBSTR(@[pod_cd], 1,5)," ).append("\n"); 
		query.append("        @[pod_cd]," ).append("\n"); 
		query.append("        @[cre_usr_id]," ).append("\n"); 
		query.append("        SYSDATE," ).append("\n"); 
		query.append("        @[cre_usr_id]," ).append("\n"); 
		query.append("        SYSDATE," ).append("\n"); 
		query.append("        NVL(@[pol_clpt_ind_seq], 1)," ).append("\n"); 
		query.append("        NVL(@[pod_clpt_ind_seq], 1))" ).append("\n"); 

	}
}