/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EQMatchBackNLoadFactorMgtDBDAOSearchMBByVessel06RSQL.java
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

public class EQMatchBackNLoadFactorMgtDBDAOSearchMBByVessel06RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchMBByVessel06
	  * </pre>
	  */
	public EQMatchBackNLoadFactorMgtDBDAOSearchMBByVessel06RSQL(){
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
		params.put("company",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.integration").append("\n"); 
		query.append("FileName : EQMatchBackNLoadFactorMgtDBDAOSearchMBByVessel06RSQL").append("\n"); 
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
		query.append("'RDR' val01,														/* dataSource */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--  DECODE(CNTR_SIZE,'2','20','3','2H','4','40','H','4H','L','45') CNTR_SIZE, SUM(M.QTY) QTY,  WGT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SUM( DECODE(  M.CNTR_TYPE, 'F', DECODE( M.CNTR_SIZE, '2', M.QTY, 0  ), 0 )) val02,    /* 20 */" ).append("\n"); 
		query.append("SUM( DECODE(  M.CNTR_TYPE, 'F', DECODE( M.CNTR_SIZE, '4', M.QTY, 0  ), 0 )) val03,    /* 40 */" ).append("\n"); 
		query.append("SUM( DECODE(  M.CNTR_TYPE, 'F', DECODE( M.CNTR_SIZE, 'H', M.QTY, 0  ), 0 )) val04,    /* HC */" ).append("\n"); 
		query.append("SUM( DECODE(  M.CNTR_TYPE, 'F', DECODE( M.CNTR_SIZE, 'L', M.QTY, 0  ), 0 )) val05,     /* 45 */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SUM( DECODE(  M.CNTR_TYPE, 'M', DECODE( M.CNTR_SIZE, '2', M.QTY, 0  ), 0 )) val06,    /* 20 */" ).append("\n"); 
		query.append("SUM( DECODE(  M.CNTR_TYPE, 'M', DECODE( M.CNTR_SIZE, '4', M.QTY, 0  ), 0 )) val07,    /* 40 */" ).append("\n"); 
		query.append("SUM( DECODE(  M.CNTR_TYPE, 'M', DECODE( M.CNTR_SIZE, 'H', M.QTY, 0  ), 0 )) val08,    /* HC */" ).append("\n"); 
		query.append("SUM( DECODE(  M.CNTR_TYPE, 'M', DECODE( M.CNTR_SIZE, 'L', M.QTY, 0  ), 0 )) val09,     /* 45 */" ).append("\n"); 
		query.append("NVL(SUM( DECODE( M.CNTR_SIZE, '2', M.WEIGHT, 0  ) ),0) +" ).append("\n"); 
		query.append("NVL(SUM( DECODE( M.CNTR_SIZE, '4', M.WEIGHT, 0  ) ),0) +" ).append("\n"); 
		query.append("NVL(SUM( DECODE( M.CNTR_SIZE, 'H', M.WEIGHT, 0  ) ),0) +" ).append("\n"); 
		query.append("NVL(SUM( DECODE( M.CNTR_SIZE, 'L', M.WEIGHT, 0  ) ),0) weightTotal" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM	RDR_HEADER		H," ).append("\n"); 
		query.append("RDR_SUMMARY		M" ).append("\n"); 
		query.append("WHERE	H.VSL_CD	= SUBSTR(@[vvd],1,4) --:vsl_cd" ).append("\n"); 
		query.append("AND		H.VOY_NO	= SUBSTR(@[vvd],5,4) --:voy_no" ).append("\n"); 
		query.append("AND		H.DIR_CD	= SUBSTR(@[vvd],9,1)    --:dir_cd" ).append("\n"); 
		query.append("AND		H.PORT_CD	= @[port] --:port" ).append("\n"); 
		query.append("AND		H.VSL_CD	= M.VSL_CD" ).append("\n"); 
		query.append("AND		H.VOY_NO	= M.VOY_NO" ).append("\n"); 
		query.append("AND		H.DIR_CD	= M.DIR_CD" ).append("\n"); 
		query.append("AND		H.REGION	= M.REGION" ).append("\n"); 
		query.append("AND		M.OPR_CD	= @[company] -- :opr_cd" ).append("\n"); 
		query.append("GROUP BY 1" ).append("\n"); 

	}
}