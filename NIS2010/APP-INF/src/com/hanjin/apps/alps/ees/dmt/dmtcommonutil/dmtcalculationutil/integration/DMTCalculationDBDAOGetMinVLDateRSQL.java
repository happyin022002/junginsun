/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : DMTCalculationDBDAOGetMinVLDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.29
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationDBDAOGetMinVLDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * getMinVLDate
	  * </pre>
	  */
	public DMTCalculationDBDAOGetMinVLDateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cnmv_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("start_mvmt_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOGetMinVLDateRSQL").append("\n"); 
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
		query.append("SELECT  /*+ INDEX (S XFN1CTM_MOVEMENT) */" ).append("\n"); 
		query.append("NVL((SELECT ATTR_CTNT5" ).append("\n"); 
		query.append("FROM DMT_HRD_CDG_CTNT" ).append("\n"); 
		query.append("WHERE HRD_CDG_ID = 'GET_MIN_OC_VL_DATE'" ).append("\n"); 
		query.append("AND ATTR_CTNT1 = @[cntr_no]" ).append("\n"); 
		query.append("AND ATTR_CTNT2 = @[cnmv_cyc_no]" ).append("\n"); 
		query.append("AND ATTR_CTNT3 = @[mvmt_sts_cd]" ).append("\n"); 
		query.append("AND ATTR_CTNT4 = @[start_mvmt_sts_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", TO_CHAR (CNMV_EVNT_DT, 'RRRRMMDD')) RTN_DTG_EFFT_DT" ).append("\n"); 
		query.append("FROM    CTM_MOVEMENT S" ).append("\n"); 
		query.append("WHERE   CNTR_NO	    = @[cntr_no]" ).append("\n"); 
		query.append("AND     MVMT_STS_CD	= @[mvmt_sts_cd]" ).append("\n"); 
		query.append("AND     (CNMV_YR || TO_CHAR (CNMV_SEQ, '0000') || CNMV_SPLIT_NO ) >" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("-- NO = 1 이 우선이지만, 1번이 없을 수 있기 때문에 NO = 2를 조회하지만," ).append("\n"); 
		query.append("-- 결과 ROW_NUMBER() 함수에서 첫번째로 리턴 받은 것을 사용한다." ).append("\n"); 
		query.append("SELECT  INDEX_KEY" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  ROW_NUMBER() OVER (ORDER BY NO) AS NO, INDEX_KEY" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("-- 조회 시작점을 찾는 Query 이다." ).append("\n"); 
		query.append("-- OP 이후 최초 발생하는 OC를 찾기 위해 이전 VD 위치를 찾는 Query 이다." ).append("\n"); 
		query.append("SELECT /*+ INDEX_DESC (S XAK11CTM_MOVEMENT) */" ).append("\n"); 
		query.append("1 AS NO, CNMV_YR || TO_CHAR (CNMV_SEQ, '0000') || CNMV_SPLIT_NO AS INDEX_KEY" ).append("\n"); 
		query.append("FROM    CTM_MOVEMENT S" ).append("\n"); 
		query.append("WHERE   CNTR_NO	    = @[cntr_no]" ).append("\n"); 
		query.append("AND     CNMV_CYC_NO	< @[cnmv_cyc_no]" ).append("\n"); 
		query.append("AND     MVMT_STS_CD	= @[start_mvmt_sts_cd]" ).append("\n"); 
		query.append("AND     ROWNUM      = 1" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("-- (1 AS NO) ( START_MVMT_STS ) 에 대한 값을 없을 경우에" ).append("\n"); 
		query.append("-- (2 AS NO)의 의미없을 값을 리턴 받기 위해 사용. (최초 발생하는 Cycle 인 때 (1 AS NO) 값이 없을 수 있기 때문." ).append("\n"); 
		query.append("SELECT  2 AS NO, '2008 0001' AS INDEX_KEY FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     NO  = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND     ROWNUM      = 1" ).append("\n"); 

	}
}