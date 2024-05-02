/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : StatusInquiryDBDAOSearchTPBStatusByBkgNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.02
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2010.04.02 최 선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sun, Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusInquiryDBDAOSearchTPBStatusByBkgNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTPBStatusByBkgNo
	  * </pre>
	  */
	public StatusInquiryDBDAOSearchTPBStatusByBkgNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sbkgno",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.integration").append("\n"); 
		query.append("FileName : StatusInquiryDBDAOSearchTPBStatusByBkgNoRSQL").append("\n"); 
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
		query.append("SELECT NVL(MIN(DECODE(OTS_STS_CD,'E',1,'L',1,'N',1,0)),-1) AS TPB_STS" ).append("\n"); 
		query.append("FROM TPB_OTS_GRP_STS" ).append("\n"); 
		query.append("WHERE N3PTY_NO IN ( SELECT A.N3PTY_NO" ).append("\n"); 
		query.append("FROM TPB_OTS_DTL A, TPB_OTS_GRP B" ).append("\n"); 
		query.append("WHERE A.N3PTY_NO = B.N3PTY_NO" ).append("\n"); 
		query.append("AND A.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("AND B.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("AND A.CXL_FLG IS NULL" ).append("\n"); 
		query.append("AND A.N3PTY_CFM_CD IN ('Y','I')" ).append("\n"); 
		query.append("AND A.BKG_NO = @[sbkgno]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND OTS_STS_LST_FLG = 'Y'" ).append("\n"); 

	}
}