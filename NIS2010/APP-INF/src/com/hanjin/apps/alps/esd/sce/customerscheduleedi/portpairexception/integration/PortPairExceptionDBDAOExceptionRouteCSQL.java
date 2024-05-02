/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PortPairExceptionDBDAOExceptionRouteCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.29
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2010.04.29 함대성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HAM DAE SUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortPairExceptionDBDAOExceptionRouteCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public PortPairExceptionDBDAOExceptionRouteCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_trd_prnr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lnk_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.integration").append("\n"); 
		query.append("FileName : PortPairExceptionDBDAOExceptionRouteCSQL").append("\n"); 
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
		query.append("INSERT INTO SCE_PORT_PAIR_EXPT(" ).append("\n"); 
		query.append("CUST_TRD_PRNR_ID" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",LNK_KNT" ).append("\n"); 
		query.append(",ORG_LOC_CD" ).append("\n"); 
		query.append(",DEST_LOC_CD" ).append("\n"); 
		query.append(",N1ST_POL_CD" ).append("\n"); 
		query.append(",N1ST_POD_CD" ).append("\n"); 
		query.append(",N1ST_LANE_CD" ).append("\n"); 
		query.append(",N1ST_SKD_DIR_CD" ).append("\n"); 
		query.append(",N2ND_POL_CD" ).append("\n"); 
		query.append(",N2ND_POD_CD" ).append("\n"); 
		query.append(",N2ND_LANE_CD" ).append("\n"); 
		query.append(",N2ND_SKD_DIR_CD" ).append("\n"); 
		query.append(",N3RD_POL_CD" ).append("\n"); 
		query.append(",N3RD_POD_CD" ).append("\n"); 
		query.append(",N3RD_LANE_CD" ).append("\n"); 
		query.append(",N3RD_SKD_DIR_CD" ).append("\n"); 
		query.append(",POR_CD" ).append("\n"); 
		query.append(",DEL_CD" ).append("\n"); 
		query.append(",DELT_FLG" ).append("\n"); 
		query.append(",USR_RMK" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")VALUES (" ).append("\n"); 
		query.append("@[cust_trd_prnr_id]" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT NVL(MAX(ROUT_SEQ),0) + 1" ).append("\n"); 
		query.append("FROM SCE_PORT_PAIR_EXPT" ).append("\n"); 
		query.append("WHERE CUST_TRD_PRNR_ID = @[cust_trd_prnr_id]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",@[lnk_knt]" ).append("\n"); 
		query.append(",@[org_loc_cd]" ).append("\n"); 
		query.append(",@[dest_loc_cd]" ).append("\n"); 
		query.append(",@[org_loc_cd]" ).append("\n"); 
		query.append(",decode(@[lnk_knt], 1, @[dest_loc_cd], 2, @[n2nd_pol_cd], 3, @[n2nd_pol_cd])" ).append("\n"); 
		query.append(",@[n1st_lane_cd]" ).append("\n"); 
		query.append(",@[n1st_skd_dir_cd]" ).append("\n"); 
		query.append(",decode(@[lnk_knt], 1, NULL, 2, @[n2nd_pol_cd], 3, @[n2nd_pol_cd])" ).append("\n"); 
		query.append(",decode(@[lnk_knt], 1, NULL, 2, @[dest_loc_cd], 3, @[n3rd_pol_cd])" ).append("\n"); 
		query.append(",@[n2nd_lane_cd]" ).append("\n"); 
		query.append(",@[n2nd_skd_dir_cd]" ).append("\n"); 
		query.append(",decode(@[lnk_knt], 1, NULL, 2, NULL, 3, @[n3rd_pol_cd])" ).append("\n"); 
		query.append(",decode(@[lnk_knt], 1, NULL, 2, NULL, 3, @[dest_loc_cd])" ).append("\n"); 
		query.append(",@[n3rd_lane_cd]" ).append("\n"); 
		query.append(",@[n3rd_skd_dir_cd]" ).append("\n"); 
		query.append(",@[por_cd]" ).append("\n"); 
		query.append(",@[del_cd]" ).append("\n"); 
		query.append(",'N'" ).append("\n"); 
		query.append(",@[usr_rmk]" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}