/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BkgCopManageDBDAOCheckExecBackEndJobRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.28
*@LastModifier : 
*@LastVersion : 1.0
* 2013.10.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOCheckExecBackEndJobRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Back End Job으로 실행해야할지 여부를 조회
	  * 
	  * - SCE_COP_HDR 에 manual로 설정된경우
	  * - outbound 운송이 종료된 경우
	  * </pre>
	  */
	public BkgCopManageDBDAOCheckExecBackEndJobRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOCheckExecBackEndJobRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("'Y' RPLN_FLG" ).append("\n"); 
		query.append("FROM SCE_COP_HDR A" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND ( EXISTS ( SELECT 'X' FROM SCE_COP_DTL B WHERE A.COP_NO = B.COP_NO AND B.COP_DTL_SEQ >= 4000 AND B.ACT_STS_CD IN ('C', 'F') )" ).append("\n"); 
		query.append("OR RPLN_JB_TP_CD = 'AV'" ).append("\n"); 
		query.append("OR 5 < (SELECT COUNT(*) CNT FROM BKG_CONTAINER B WHERE A.BKG_NO = B.BKG_NO)" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("AND ROWNUM=1" ).append("\n"); 

	}
}