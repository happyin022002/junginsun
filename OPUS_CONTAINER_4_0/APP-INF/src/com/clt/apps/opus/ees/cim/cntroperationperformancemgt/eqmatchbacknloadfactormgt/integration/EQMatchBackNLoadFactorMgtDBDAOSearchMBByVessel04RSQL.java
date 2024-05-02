/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EQMatchBackNLoadFactorMgtDBDAOSearchMBByVessel04RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.21
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2009.12.21 박광석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Prak Kwang Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQMatchBackNLoadFactorMgtDBDAOSearchMBByVessel04RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Match-back by Vessel
	  * </pre>
	  */
	public EQMatchBackNLoadFactorMgtDBDAOSearchMBByVessel04RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("company",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fromdate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("todate",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.integration").append("\n"); 
		query.append("FileName : EQMatchBackNLoadFactorMgtDBDAOSearchMBByVessel04RSQL").append("\n"); 
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
		query.append("SELECT	'BAY' val01,														/* dataSource */" ).append("\n"); 
		query.append("COUNT(DECODE(FE, 'F', DECODE(SUBSTR(SZTP,2,1), '2', SZTP))) val02,	/* full20Qty */" ).append("\n"); 
		query.append("COUNT(DECODE(FE, 'F', DECODE(SUBSTR(SZTP,2,1), '4', SZTP))) val03,	/* full40Qty */" ).append("\n"); 
		query.append("COUNT(DECODE(FE, 'F', DECODE(SUBSTR(SZTP,2,1), '5', SZTP))) val04,	/* fullHcQty */" ).append("\n"); 
		query.append("COUNT(DECODE(FE, 'F', DECODE(SUBSTR(SZTP,2,1), '7', SZTP))) val05,	/* full45Qty */" ).append("\n"); 
		query.append("COUNT(DECODE(FE, 'E', DECODE(SUBSTR(SZTP,2,1), '2', SZTP))) val06,	/* mty20Qty  */" ).append("\n"); 
		query.append("COUNT(DECODE(FE, 'E', DECODE(SUBSTR(SZTP,2,1), '4', SZTP))) val07,	/* mty40Qty  */" ).append("\n"); 
		query.append("COUNT(DECODE(FE, 'E', DECODE(SUBSTR(SZTP,2,1), '5', SZTP))) val08,	/* mtyHcQty  */" ).append("\n"); 
		query.append("COUNT(DECODE(FE, 'E', DECODE(SUBSTR(SZTP,2,1), '7', SZTP))) val09,	/* mty45Qty  */" ).append("\n"); 
		query.append("SUM(NVL(TO_NUMBER(TRIM(WEIGHT)), 0))	weightTotal" ).append("\n"); 
		query.append("FROM    BAY_PLAN" ).append("\n"); 
		query.append("WHERE   VSL_CD		=	SUBSTR(@[trade],1,4)" ).append("\n"); 
		query.append("AND     VOY_NO		=	SUBSTR(@[trade],5,4)" ).append("\n"); 
		query.append("AND		DIR_CD      =	SUBSTR(@[trade],9,1)" ).append("\n"); 
		query.append("AND		PORT_CD		=	@[fromdate]" ).append("\n"); 
		query.append("AND		CALL_IND	=	@[todate]" ).append("\n"); 
		query.append("#if ( ${company} != 'TTL' )" ).append("\n"); 
		query.append("AND     OPR_CD		=	@[company]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND		PLAN_TYPE	= 'F'" ).append("\n"); 
		query.append("GROUP BY OPR_CD" ).append("\n"); 

	}
}