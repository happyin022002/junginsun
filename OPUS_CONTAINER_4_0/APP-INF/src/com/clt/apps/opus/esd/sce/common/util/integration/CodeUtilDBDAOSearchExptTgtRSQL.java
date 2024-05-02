/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CodeUtilDBDAOSearchExptTgtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.22
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.01.22 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.common.util.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CodeUtilDBDAOSearchExptTgtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * exception 판별 대상 cop 의 정보를 조회한다.
	  * </pre>
	  */
	public CodeUtilDBDAOSearchExptTgtRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.common.util.integration ").append("\n"); 
		query.append("FileName : CodeUtilDBDAOSearchExptTgtRSQL").append("\n"); 
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
		query.append("SELECT d.cop_no," ).append("\n"); 
		query.append("d.cop_dtl_seq," ).append("\n"); 
		query.append("to_char(d.act_dt, 'yyyymmddhh24miss')act_dt ," ).append("\n"); 
		query.append("decode(ACT_CD, 'FIRRLO', 'AL', 'FIRRDO', 'RL', 'N') rd_eta_flg," ).append("\n"); 
		query.append("NOD_CD" ).append("\n"); 
		query.append("FROM sce_cop_dtl d," ).append("\n"); 
		query.append("sce_cop_hdr h" ).append("\n"); 
		query.append("WHERE h.cop_no = @[cop_no]" ).append("\n"); 
		query.append("and d.cop_no = h.cop_no" ).append("\n"); 
		query.append("AND (d.cop_dtl_seq < 4000" ).append("\n"); 
		query.append("OR d.cop_dtl_seq >= 6000)" ).append("\n"); 
		query.append("AND d.act_dt is not null" ).append("\n"); 
		query.append("AND h.cop_sts_cd not in ('X', 'F')" ).append("\n"); 
		query.append("order by d.cop_no, d.cop_dtl_seq" ).append("\n"); 

	}
}