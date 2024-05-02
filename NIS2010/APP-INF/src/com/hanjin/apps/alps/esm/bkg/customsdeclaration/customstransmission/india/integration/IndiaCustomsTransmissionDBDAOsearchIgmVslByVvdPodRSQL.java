/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IndiaCustomsTransmissionDBDAOsearchIgmVslByVvdPodRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.25
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.11.25 경종윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.india.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kyoung Jong Yun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IndiaCustomsTransmissionDBDAOsearchIgmVslByVvdPodRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 인도세관테이블에서 VVD의 상세 정보를 가져온다.
	  * </pre>
	  */
	public IndiaCustomsTransmissionDBDAOsearchIgmVslByVvdPodRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.india.integration").append("\n"); 
		query.append("FileName : IndiaCustomsTransmissionDBDAOsearchIgmVslByVvdPodRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("IDA_DECL_VSL_NO" ).append("\n"); 
		query.append(",VSL_DECL_DT" ).append("\n"); 
		query.append(",VSL_NM" ).append("\n"); 
		query.append(",SUBSTR(CALL_SGN_NO, 1, 7) CALL_SGN_NO" ).append("\n"); 
		query.append(",SKD_VOY_NO" ).append("\n"); 
		query.append(",IDA_LINE_NO" ).append("\n"); 
		query.append(",IDA_AGN_ID" ).append("\n"); 
		query.append(",SUBSTR(OTR_DCHG_YD_ID, 1, 6) PORT_CD" ).append("\n"); 
		query.append(",ARR_DT" ).append("\n"); 
		query.append("FROM    BKG_CSTMS_IDA_VSL" ).append("\n"); 
		query.append("WHERE   VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("AND     SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("AND     SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("AND     POD_CD      = @[pod_cd]" ).append("\n"); 

	}
}