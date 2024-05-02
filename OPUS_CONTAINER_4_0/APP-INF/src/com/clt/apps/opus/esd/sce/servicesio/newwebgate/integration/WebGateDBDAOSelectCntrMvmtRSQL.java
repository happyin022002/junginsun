/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WebGateDBDAOSelectCntrMvmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.10
*@LastModifier : 윤권영
*@LastVersion : 1.0
* 2009.10.10 윤권영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.servicesio.newwebgate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yun Kwon Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WebGateDBDAOSelectCntrMvmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container Movement 상태를 조회한다.
	  * </pre>
	  */
	public WebGateDBDAOSelectCntrMvmtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkbl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.servicesio.newwebgate.integration").append("\n"); 
		query.append("FileName : WebGateDBDAOSelectCntrMvmtRSQL").append("\n"); 
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
		query.append("SELECT e.COMPANY," ).append("\n"); 
		query.append("e.MVMT_STS," ).append("\n"); 
		query.append("e.YARD," ).append("\n"); 
		query.append("e.EVNT_DT FROM (" ).append("\n"); 
		query.append("SELECT d.COMPANY," ).append("\n"); 
		query.append("d.MVMT_STS," ).append("\n"); 
		query.append("d.YARD," ).append("\n"); 
		query.append("d.EVNT_DT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT DECODE(a.CNMV_CO_CD,'HJS','Hanjin','SEN','Senator') COMPANY," ).append("\n"); 
		query.append("b.MVMT_STS_NM MVMT_STS," ).append("\n"); 
		query.append("c.YD_NM YARD," ).append("\n"); 
		query.append("TO_CHAR(a.CNMV_EVNT_DT,'yyyy-mm-dd hh24:mi') EVNT_DT" ).append("\n"); 
		query.append("from   CTM_MOVEMENT a," ).append("\n"); 
		query.append("MDM_MVMT_STS b," ).append("\n"); 
		query.append("MDM_YARD     c" ).append("\n"); 
		query.append("where  1=1" ).append("\n"); 
		query.append("and    (a.BKG_NO  = @[bkbl_no] OR a.BL_NO = @[bkbl_no])" ).append("\n"); 
		query.append("and    a.CNTR_NO  = @[cntr_no]" ).append("\n"); 
		query.append("and    a.MVMT_STS_CD = b.MVMT_STS_CD" ).append("\n"); 
		query.append("and    a.ORG_YD_CD = c.YD_CD" ).append("\n"); 
		query.append("ORDER BY CNMV_YR || TO_NUMBER(CNMV_SEQ) DESC" ).append("\n"); 
		query.append(") d" ).append("\n"); 
		query.append("WHERE ROWNUM < 6" ).append("\n"); 
		query.append(") e" ).append("\n"); 
		query.append("ORDER BY EVNT_DT" ).append("\n"); 

	}
}