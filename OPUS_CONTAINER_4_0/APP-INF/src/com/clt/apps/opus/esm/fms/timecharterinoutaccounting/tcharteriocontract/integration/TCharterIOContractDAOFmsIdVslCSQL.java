/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TCharterIOContractDAOFmsIdVslCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2010.02.01 윤세영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon, Seyeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOContractDAOFmsIdVslCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOContractDAOFmsIdVslCSQL
	  * </pre>
	  */
	public TCharterIOContractDAOFmsIdVslCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_rpt_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.integration").append("\n"); 
		query.append("FileName : TCharterIOContractDAOFmsIdVslCSQL").append("\n"); 
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
		query.append("insert into fms_id_vsl (" ).append("\n"); 
		query.append("	flet_ctrt_no," ).append("\n"); 
		query.append("	vsl_cd," ).append("\n"); 
		query.append("	use_flg," ).append("\n"); 
		query.append("	flet_rpt_flg," ).append("\n"); 
		query.append("	cre_usr_id," ).append("\n"); 
		query.append("	cre_dt," ).append("\n"); 
		query.append("	upd_usr_id," ).append("\n"); 
		query.append("	upd_dt" ).append("\n"); 
		query.append(") values( " ).append("\n"); 
		query.append("	@[flet_ctrt_no]," ).append("\n"); 
		query.append("	@[vsl_cd]," ).append("\n"); 
		query.append("	DECODE(@[use_flg],'1','Y','N')," ).append("\n"); 
		query.append("	DECODE(@[flet_rpt_flg],'1','Y','N')," ).append("\n"); 
		query.append("	@[cre_usr_id]," ).append("\n"); 
		query.append("	sysdate," ).append("\n"); 
		query.append("	@[upd_usr_id]," ).append("\n"); 
		query.append("	sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}