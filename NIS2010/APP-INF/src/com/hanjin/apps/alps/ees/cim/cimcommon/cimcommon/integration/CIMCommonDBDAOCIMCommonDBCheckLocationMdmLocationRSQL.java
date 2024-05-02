/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CIMCommonDBDAOCIMCommonDBCheckLocationMdmLocationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.23
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cimcommon.cimcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CIMCommonDBDAOCIMCommonDBCheckLocationMdmLocationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * 
	  * * 수정이력
	  * 1. 2013-01-21, 신용찬 수석, AND    DELT_FLG = 'N' 조건 추가
	  * </pre>
	  */
	public CIMCommonDBDAOCIMCommonDBCheckLocationMdmLocationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locCD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locLevel",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.cimcommon.cimcommon.integration").append("\n"); 
		query.append("FileName : CIMCommonDBDAOCIMCommonDBCheckLocationMdmLocationRSQL").append("\n"); 
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
		query.append("#if (${locLevel} == 'Y')" ).append("\n"); 
		query.append("SELECT *" ).append("\n"); 
		query.append("FROM  MDM_YARD" ).append("\n"); 
		query.append("WHERE YD_CD = @[locCD]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${locLevel} == 'O' || ${locLevel} == 'C' || ${locLevel} == 'P')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT * " ).append("\n"); 
		query.append("FROM    MDM_LOCATION" ).append("\n"); 
		query.append("WHERE   LOC_CD          LIKE  @[locCD]||'%'" ).append("\n"); 
		query.append("AND     PORT_INLND_CD  =   DECODE( @[locLevel], 'P', 'Y', PORT_INLND_CD)  " ).append("\n"); 
		query.append("AND    ROWNUM =1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${locLevel} == 'V')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT * " ).append("\n"); 
		query.append("FROM    MDM_LOCATION" ).append("\n"); 
		query.append("WHERE   LOC_CD          =  @[locCD]" ).append("\n"); 
		query.append("AND     DELT_FLG = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${locLevel} == 'B')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT * " ).append("\n"); 
		query.append("FROM    BKG_BOOKING" ).append("\n"); 
		query.append("WHERE   BKG_NO          =  @[locCD]" ).append("\n"); 
		query.append("AND     BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${locLevel} == 'W')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT *" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND OFC_CD = @[locCD]" ).append("\n"); 
		query.append("AND OFC_KND_CD = '2'" ).append("\n"); 
		query.append("AND NVL(DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${locLevel} == 'K')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT *" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND OFC_CD = @[locCD]" ).append("\n"); 
		query.append("AND NVL(DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${locLevel} == 'U')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT *" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER A" ).append("\n"); 
		query.append("WHERE 1 = 1 " ).append("\n"); 
		query.append("AND A.CUST_CNT_CD||LPAD(A.CUST_SEQ,6,0) = @[locCD]" ).append("\n"); 
		query.append("AND A.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT *" ).append("\n"); 
		query.append("FROM    MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("WHERE  	DECODE ( @[locLevel] ,  'S',  SCC_CD	,  /* SCC */ " ).append("\n"); 
		query.append("	                          'E',  ECC_CD	,  /* ECC */" ).append("\n"); 
		query.append("	                          'L',  LCC_CD	,  /* LCC */" ).append("\n"); 
		query.append(" 		                            RCC_CD   ) /* RCC */" ).append("\n"); 
		query.append("	       =	@[locCD]" ).append("\n"); 
		query.append("AND    DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND    ROWNUM =1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}