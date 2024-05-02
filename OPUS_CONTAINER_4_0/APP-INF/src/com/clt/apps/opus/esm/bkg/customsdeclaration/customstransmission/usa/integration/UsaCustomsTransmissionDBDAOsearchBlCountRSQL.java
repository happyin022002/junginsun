/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchBlCountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.01
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.12.01 경종윤
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kyoung Jong Yun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchBlCountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchBlCountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchBlCountRSQL").append("\n"); 
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
		query.append("SELECT  NVL(COUNT(BL_NO),0)" ).append("\n"); 
		query.append("FROM    BKG_CSTMS_ADV_BL" ).append("\n"); 
		query.append("WHERE   VSL_CD      = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND     SKD_VOY_NO   = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND     SKD_DIR_CD  = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("-----------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("-- 2009/08/28 정민정 과장, HI화면의 BL수량과 MI화면의 BL 수량이 틀리다는 문의에 대해 분석결과," ).append("\n"); 
		query.append("-- MI에서는 POD,POL조건을 CSTMS 값으로 조회하는 차이점을 발견," ).append("\n"); 
		query.append("-- 하동일 수석 가이드로 이곳에서도 CSTMS로 조회하도록 수정." ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("AND     CSTMS_POL_CD     = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND     CSTMS_POD_CD     = @[pod_cd]" ).append("\n"); 
		query.append("-----------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("AND     MF_STS_CD   in( 'A', NVL(@[pol_cd], 'F'))" ).append("\n"); 
		query.append("AND     MF_NO IS NULL" ).append("\n"); 
		query.append("AND     CNT_CD = 'US'" ).append("\n"); 

	}
}