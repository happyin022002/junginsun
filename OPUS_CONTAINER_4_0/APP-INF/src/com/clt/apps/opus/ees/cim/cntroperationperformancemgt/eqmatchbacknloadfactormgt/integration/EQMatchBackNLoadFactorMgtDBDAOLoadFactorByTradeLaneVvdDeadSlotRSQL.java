/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EQMatchBackNLoadFactorMgtDBDAOLoadFactorByTradeLaneVvdDeadSlotRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.28
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2009.12.28 박광석
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

public class EQMatchBackNLoadFactorMgtDBDAOLoadFactorByTradeLaneVvdDeadSlotRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * LoadFactorByTradeLaneVvdDeadSlot 조회
	  * </pre>
	  */
	public EQMatchBackNLoadFactorMgtDBDAOLoadFactorByTradeLaneVvdDeadSlotRSQL(){
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
		params.put("port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fromregion",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("company",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.integration").append("\n"); 
		query.append("FileName : EQMatchBackNLoadFactorMgtDBDAOLoadFactorByTradeLaneVvdDeadSlotRSQL").append("\n"); 
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
		query.append("#if (${gubun} == '1')" ).append("\n"); 
		query.append("-- deadSlot" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("NVL(SUM(DECODE(M.TYPE,'A',M.SLOT_QTY,0))" ).append("\n"); 
		query.append("+SUM(DECODE(M.TYPE,'H',M.SLOT_QTY,'L',M.SLOT_QTY,0)),0) deadSlot /* deadSlot	*/" ).append("\n"); 
		query.append("FROM    RDR_HEADER      H," ).append("\n"); 
		query.append("RDR_UTILIZE     M" ).append("\n"); 
		query.append("WHERE	H.VSL_CD     =	SUBSTR(@[vvd],1,4) --:vsl_cd" ).append("\n"); 
		query.append("AND		H.VOY_NO     =	SUBSTR(@[vvd],5,4) --:voy_no" ).append("\n"); 
		query.append("AND		H.DIR_CD     =	SUBSTR(@[vvd],9,1)    --:dir_cd" ).append("\n"); 
		query.append("AND     H.REGION    =   @[fromregion]     --  /* from_region		*/" ).append("\n"); 
		query.append("AND     H.VSL_CD    =   M.VSL_CD" ).append("\n"); 
		query.append("AND     H.VOY_NO    =   M.VOY_NO" ).append("\n"); 
		query.append("AND     H.DIR_CD    =   M.DIR_CD" ).append("\n"); 
		query.append("AND     H.REGION    =   M.REGION" ).append("\n"); 
		query.append("AND     M.OPR_CD    =   @[company]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${gubun} == '2')" ).append("\n"); 
		query.append("-- released_teu/wgt" ).append("\n"); 
		query.append("SELECT	/*+ ORDERED USE_NL(H M) */" ).append("\n"); 
		query.append("NVL(SUM(M.SLOT),0)   releasedteu," ).append("\n"); 
		query.append("NVL(SUM(M.WEIGHT),0) releasedweight" ).append("\n"); 
		query.append("FROM	RDR_HEADER			H," ).append("\n"); 
		query.append("RDR_SLOT_RELEASE	M" ).append("\n"); 
		query.append("WHERE	H.VSL_CD     =	SUBSTR(@[vvd],1,4) --:vsl_cd" ).append("\n"); 
		query.append("AND		H.VOY_NO     =	SUBSTR(@[vvd],5,4) --:voy_no" ).append("\n"); 
		query.append("AND		H.DIR_CD     =	SUBSTR(@[vvd],9,1)    --:dir_cd" ).append("\n"); 
		query.append("AND		H.PORT_CD	= @[port] --:port" ).append("\n"); 
		query.append("AND		H.VSL_CD	= M.VSL_CD" ).append("\n"); 
		query.append("AND		H.VOY_NO	= M.VOY_NO" ).append("\n"); 
		query.append("AND		H.DIR_CD	= M.DIR_CD" ).append("\n"); 
		query.append("AND		H.REGION	= M.REGION" ).append("\n"); 
		query.append("AND     M.OPR_CD    = @[company]	--:oper_in" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}