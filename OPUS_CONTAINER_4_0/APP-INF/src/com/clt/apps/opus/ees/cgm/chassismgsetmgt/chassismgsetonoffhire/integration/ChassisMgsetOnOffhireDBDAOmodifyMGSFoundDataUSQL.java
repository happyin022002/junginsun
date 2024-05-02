/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMgsetOnOffhireDBDAOmodifyMGSFoundDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.06
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2010.08.06 나상보
* 	[CHM-201004960-01] Genset Ineventory Logic error 수정건
*    	: [EES_CGM_2019] Lost 된 M.G.Set 을 Found 시 Current Location 도 업데이트 하는 로직 추가 by 나상보
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LA SANG-BO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetOnOffhireDBDAOmodifyMGSFoundDataUSQL implements ISQLTemplate{ 

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CGM_EQUIPMENT 업데이트
	  * 
	  *  [CHM-201004960-01] Genset Ineventory Logic error 수정건
	  *     : [EES_CGM_2019] Lost 된 M.G.Set 을 Found 시 Current Location 도 업데이트 하는 로직 추가 by 나상보
	  *       - CRNT_LOC_CD  = SUBSTR(@[f_evnt_yd_cd],0,5)
	  * </pre>
	  */
	public ChassisMgsetOnOffhireDBDAOmodifyMGSFoundDataUSQL(){ 
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_evnt_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration").append("\n"); 
		query.append("FileName : ChassisMgsetOnOffhireDBDAOmodifyMGSFoundDataUSQL").append("\n"); 
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
		query.append("UPDATE CGM_EQUIPMENT" ).append("\n"); 
		query.append(" SET ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append("    ,CRNT_YD_CD   = @[f_evnt_yd_cd]" ).append("\n"); 
		query.append("	,CRNT_LOC_CD  = SUBSTR(@[f_evnt_yd_cd],0,5)" ).append("\n"); 
		query.append("    ,CHSS_MVMT_STS_CD = 'BI'" ).append("\n"); 
		query.append("    ,EQ_STS_SEQ       =  NVL(CGM_GET_EQ_STS_HIS_MAXSEQ_FNC(@[eq_no]) ,0)" ).append("\n"); 
		query.append("    ,UPD_USR_ID       = @[user_id]" ).append("\n"); 
		query.append("    ,UPD_DT           = sysdate" ).append("\n"); 
		query.append(" WHERE EQ_NO = @[eq_no]" ).append("\n"); 

	}
}