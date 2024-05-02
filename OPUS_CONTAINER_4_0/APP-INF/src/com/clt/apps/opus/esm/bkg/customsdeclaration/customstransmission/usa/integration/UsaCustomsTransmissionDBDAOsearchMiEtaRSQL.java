/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchMiEtaRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.03
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.12.03 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchMiEtaRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchMiEtaRSQL(){
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
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchMiEtaRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(NVL(" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  ETA_DT" ).append("\n"); 
		query.append("FROM  BKG_CSTMS_ADV_VVD_ARR" ).append("\n"); 
		query.append("WHERE  CNT_CD = 'US'" ).append("\n"); 
		query.append("AND  VSL_CD        = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND  SKD_VOY_NO    = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND  SKD_DIR_CD    = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND  POD_CD        = @[pod]" ).append("\n"); 
		query.append("AND  ROWNUM = 1" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  VSL_ARR_DT" ).append("\n"); 
		query.append("FROM  BKG_CSTMS_ADV_BL" ).append("\n"); 
		query.append("WHERE  CNT_CD = 'US'" ).append("\n"); 
		query.append("AND  VSL_CD        = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND  SKD_VOY_NO    = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND  SKD_DIR_CD    = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND  POD_CD        = @[pod]" ).append("\n"); 
		query.append("AND  MF_STS_CD    = 'A'" ).append("\n"); 
		query.append("AND  VSL_ARR_DT    IS NOT NULL" ).append("\n"); 
		query.append("AND  LENGTH(VSL_ARR_DT) = 6" ).append("\n"); 
		query.append("AND  ROWNUM        = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("), 'MMDDRR') ETA" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}