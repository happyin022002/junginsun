/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CopDetailReceiveDBDAOModifyCopCostByMVMTUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08
*@LastModifier : 김성일
*@LastVersion : 1.0
* 2009.09.08 김성일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copdetailreceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sungil Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOModifyCopCostByMVMTUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyCopCostByMVMT
	  * </pre>
	  */
	public CopDetailReceiveDBDAOModifyCopCostByMVMTUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("IN_COP_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("v_cop_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_cnmv_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOModifyCopCostByMVMTUSQL").append("\n"); 
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
		query.append("update sce_cost_act_grp" ).append("\n"); 
		query.append("set    trsp_so_sts_cd = 'X'" ).append("\n"); 
		query.append(",upd_dt         = SYSDATE" ).append("\n"); 
		query.append(",upd_usr_id     = 'MVMT_STS'" ).append("\n"); 
		query.append(",wo_exe_dt      = to_date(@[in_cnmv_evnt_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("where  cop_no   = @[IN_COP_NO]" ).append("\n"); 
		query.append("and    trsp_so_sts_cd   = 'I'" ).append("\n"); 
		query.append("and  (cost_act_grp_seq, @[v_cop_dtl_seq])" ).append("\n"); 
		query.append("= (select a.cost_act_grp_seq, max(b.cop_dtl_seq)" ).append("\n"); 
		query.append("from   sce_cost_act_grp a, sce_cop_dtl b" ).append("\n"); 
		query.append("where  b.cop_no           = @[IN_COP_NO]" ).append("\n"); 
		query.append("and    b.cop_dtl_seq      = @[v_cop_dtl_seq])" ).append("\n"); 
		query.append("and    a.cop_no           = b.cop_no" ).append("\n"); 
		query.append("and    a.cost_act_grp_seq >= (b.cop_dtl_seq/1000)*100" ).append("\n"); 
		query.append("and    a.cost_act_grp_seq < (case when b.cop_dtl_seq < 4000 then 400 when b.cop_dtl_seq > 6000 then 700 else 600 end)" ).append("\n"); 
		query.append("and    a.trsp_so_sts_cd   = 'I'" ).append("\n"); 
		query.append("group by a.cost_act_grp_seq" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}