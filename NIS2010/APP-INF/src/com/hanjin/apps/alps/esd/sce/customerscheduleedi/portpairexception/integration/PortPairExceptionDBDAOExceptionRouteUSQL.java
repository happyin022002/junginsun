/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PortPairExceptionDBDAOExceptionRouteUSQL.java
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

public class PortPairExceptionDBDAOExceptionRouteUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public PortPairExceptionDBDAOExceptionRouteUSQL(){
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
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.integration").append("\n"); 
		query.append("FileName : PortPairExceptionDBDAOExceptionRouteUSQL").append("\n"); 
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
		query.append("UPDATE SCE_PORT_PAIR_EXPT" ).append("\n"); 
		query.append("SET 	 LNK_KNT        	=	@[lnk_knt]" ).append("\n"); 
		query.append(",N1ST_POD_CD    	=	decode(@[lnk_knt], 1, @[dest_loc_cd], 2, @[n2nd_pol_cd], 3, @[n2nd_pol_cd])" ).append("\n"); 
		query.append(",N1ST_LANE_CD   	=	@[n1st_lane_cd]" ).append("\n"); 
		query.append(",N1ST_SKD_DIR_CD	=	@[n1st_skd_dir_cd]" ).append("\n"); 
		query.append(",N2ND_POL_CD    	=	decode(@[lnk_knt], 1, NULL, 2, @[n2nd_pol_cd], 3, @[n2nd_pol_cd])" ).append("\n"); 
		query.append(",N2ND_POD_CD    	=	decode(@[lnk_knt], 1, NULL, 2, @[dest_loc_cd], 3, @[n3rd_pol_cd])" ).append("\n"); 
		query.append(",N3RD_POL_CD        =   decode(@[lnk_knt], 1, NULL, 2, NULL, 3, @[n3rd_pol_cd])" ).append("\n"); 
		query.append(",N2ND_LANE_CD   	=	@[n2nd_lane_cd]" ).append("\n"); 
		query.append(",N3RD_LANE_CD   	=	@[n3rd_lane_cd]" ).append("\n"); 
		query.append(",N2ND_SKD_DIR_CD	=	@[n2nd_skd_dir_cd]" ).append("\n"); 
		query.append(",N3RD_SKD_DIR_CD	=	@[n3rd_skd_dir_cd]" ).append("\n"); 
		query.append(",N3RD_POD_CD        =   decode(@[lnk_knt], 1, NULL, 2, NULL, 3, @[dest_loc_cd])" ).append("\n"); 
		query.append(",USR_RMK			=   @[usr_rmk]" ).append("\n"); 
		query.append(",UPD_USR_ID			=   @[upd_usr_id]" ).append("\n"); 
		query.append(",UPD_DT				=   SYSDATE" ).append("\n"); 
		query.append("WHERE CUST_TRD_PRNR_ID 	= @[cust_trd_prnr_id]" ).append("\n"); 
		query.append("AND ROUT_SEQ				= @[rout_seq]" ).append("\n"); 
		query.append("AND ORG_LOC_CD  		  	= @[org_loc_cd]" ).append("\n"); 
		query.append("AND DEST_LOC_CD 		  	= @[dest_loc_cd]" ).append("\n"); 
		query.append("AND POR_CD 				= @[por_cd]" ).append("\n"); 
		query.append("AND DEL_CD 				= @[del_cd]" ).append("\n"); 

	}
}