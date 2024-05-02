/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ReceiveQueueMdmCntrVndrClssDBDAOModifyMdmCntrVndrClssUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.30
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2010.06.30 박재흥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author park chae heung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveQueueMdmCntrVndrClssDBDAOModifyMdmCntrVndrClssUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MDM_CNTR_VNDR_CLSS 의 정보를 update 한다.
	  * (실질적으로 cre_usr_id 등 4개 정보 만 update 하는데 어떤 의미가 있는지는 미상)
	  * </pre>
	  */
	public ReceiveQueueMdmCntrVndrClssDBDAOModifyMdmCntrVndrClssUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eai_if_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vndr_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_vndr_svc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.common.mdmSync.jms.integration").append("\n"); 
		query.append("FileName : ReceiveQueueMdmCntrVndrClssDBDAOModifyMdmCntrVndrClssUSQL").append("\n"); 
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
		query.append("UPDATE	MDM_CNTR_VNDR_CLSS SET" ).append("\n"); 
		query.append("cre_usr_id  = @[cre_usr_id]," ).append("\n"); 
		query.append("cre_dt      = TO_DATE(@[cre_dt],'yyyymmddhh24miss')," ).append("\n"); 
		query.append("upd_usr_id  = @[upd_usr_id]," ).append("\n"); 
		query.append("upd_dt      = TO_DATE(@[upd_dt],'yyyymmddhh24miss')," ).append("\n"); 
		query.append("delt_flg    = NVL(@[delt_flg],'N')," ).append("\n"); 
		query.append("eai_evnt_dt = SYSDATE," ).append("\n"); 
		query.append("eai_if_id	= @[eai_if_id]" ).append("\n"); 
		query.append("WHERE	vndr_seq = @[vndr_seq]" ).append("\n"); 
		query.append("AND		vndr_cost_cd = @[vndr_cost_cd]" ).append("\n"); 
		query.append("AND		cntr_vndr_svc_cd = @[cntr_vndr_svc_cd]" ).append("\n"); 

	}
}