/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SettlementProcessDBDAOJoRevLoadingDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.22
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2016.03.22 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SettlementProcessDBDAOJoRevLoadingDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Jo Rev Loading 정보를 삭제한다.
	  * </pre>
	  */
	public SettlementProcessDBDAOJoRevLoadingDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.integration").append("\n"); 
		query.append("FileName : SettlementProcessDBDAOJoRevLoadingDSQL").append("\n"); 
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
		query.append("DELETE FROM JOO_LODG_TGT J" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND J.REV_YRMON		= @[rev_yrmon]		      " ).append("\n"); 
		query.append("--AND J.REV_YRMON_SEQ " ).append("\n"); 
		query.append("AND J.TRD_CD        = @[trd_cd]" ).append("\n"); 
		query.append("AND J.CRR_CD        = @[crr_cd]" ).append("\n"); 
		query.append("AND J.RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("AND J.RE_DIVR_CD    = 'R'" ).append("\n"); 
		query.append("AND J.VSL_CD        = @[vsl_cd]  " ).append("\n"); 
		query.append("AND J.SKD_VOY_NO    = @[skd_voy_no]	 " ).append("\n"); 
		query.append("AND J.SKD_DIR_CD    = @[skd_dir_cd]  " ).append("\n"); 
		query.append("AND J.VPS_PORT_CD   = @[vps_port_cd] " ).append("\n"); 
		query.append("#if (${yd_cd} != '')  " ).append("\n"); 
		query.append("AND J.YD_CD         = @[yd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${clpt_ind_seq} != '') " ).append("\n"); 
		query.append("AND J.CLPT_IND_SEQ	= @[clpt_ind_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}