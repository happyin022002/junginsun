/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ReplanManageDBDAOModifySoStsPlnByUmchSoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.07
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2011.06.07 김인수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReplanManageDBDAOModifySoStsPlnByUmchSoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCE_PLN_SO_LIST 의 SO Status 가 Planned 가 아닐 경우 해당 route 에 unmatched S/O 가 생성되었을 때 이를 다시 Planned 로 복구
	  * </pre>
	  */
	public ReplanManageDBDAOModifySoStsPlnByUmchSoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_act_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.integration").append("\n"); 
		query.append("FileName : ReplanManageDBDAOModifySoStsPlnByUmchSoUSQL").append("\n"); 
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
		query.append("update sce_pln_so_list" ).append("\n"); 
		query.append("set" ).append("\n"); 
		query.append("trsp_so_sts_cd = 'P'" ).append("\n"); 
		query.append("where" ).append("\n"); 
		query.append("cop_no = @[cop_no]" ).append("\n"); 
		query.append("and cost_act_grp_seq = @[cost_act_grp_seq]" ).append("\n"); 
		query.append("and trsp_so_sts_cd != 'P'" ).append("\n"); 
		query.append("and (select nvl(rpln_umch_flg, 'N') " ).append("\n"); 
		query.append("		from trs_trsp_svc_ord where cop_no = @[cop_no] and cost_act_grp_seq = @[cost_act_grp_seq]" ).append("\n"); 
		query.append("		and NVL(trsp_frst_flg, 'N') = 'N' and nvl(delt_flg, 'N') = 'N' and rownum = 1" ).append("\n"); 
		query.append("	) = 'Y'" ).append("\n"); 

	}
}