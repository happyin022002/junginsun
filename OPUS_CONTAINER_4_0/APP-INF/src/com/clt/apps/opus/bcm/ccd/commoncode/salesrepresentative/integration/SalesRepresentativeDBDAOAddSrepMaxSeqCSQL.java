/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SalesRepresentativeDBDAOAddSrepMaxSeqCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.17
*@LastModifier : 윤태승
*@LastVersion : 1.0
* 2012.07.17 윤태승
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.salesrepresentative.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author YunTaeSeung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SalesRepresentativeDBDAOAddSrepMaxSeqCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 새로운 CNT_CD 별 SREP_MAX_SEQ 정보를 추가한다.
	  * </pre>
	  */
	public SalesRepresentativeDBDAOAddSrepMaxSeqCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.salesrepresentative.integration ").append("\n"); 
		query.append("FileName : SalesRepresentativeDBDAOAddSrepMaxSeqCSQL").append("\n"); 
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
		query.append("INSERT INTO MDM_SLS_REP_SEQ_MGMT" ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("	CNT_CD, " ).append("\n"); 
		query.append("	SREP_MAX_SEQ, " ).append("\n"); 
		query.append("	CRE_USR_ID, " ).append("\n"); 
		query.append("	CRE_DT, " ).append("\n"); 
		query.append("	UPD_USR_ID, " ).append("\n"); 
		query.append("	UPD_DT" ).append("\n"); 
		query.append(") VALUES ( " ).append("\n"); 
		query.append("	@[cnt_cd]," ).append("\n"); 
		query.append("	1," ).append("\n"); 
		query.append("	@[usr_id]," ).append("\n"); 
		query.append("	NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]), SYSDATE)," ).append("\n"); 
		query.append("	@[usr_id]," ).append("\n"); 
		query.append("	NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]), SYSDATE) " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}