/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InterfaceMgtDBDAOsearchTempEstimateCostCdDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.20
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.05.20 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author park myoung sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InterfaceMgtDBDAOsearchTempEstimateCostCdDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchTempEstimateCostCdData
	  * </pre>
	  */
	public InterfaceMgtDBDAOsearchTempEstimateCostCdDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmpo_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tp_sz",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.integration").append("\n"); 
		query.append("FileName : InterfaceMgtDBDAOsearchTempEstimateCostCdDataRSQL").append("\n"); 
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
		query.append("SELECT C.EQ_CMPO_CD,C.EQ_CMPO_NM,C.COST_CD FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A.EQ_CMPO_CD, A.EQ_CMPO_NM,  DECODE(DM.EQ_KND_CD, 'Z', 'MRZSRC', 'G', 'MRGSRC', 'U'," ).append("\n"); 
		query.append("DECODE(SUBSTR(DM.TP_SZ, 1, 1) ,'D', 'MRDRRC'" ).append("\n"); 
		query.append(",'R',  DECODE(B.EQ_PRNT_CMPO_CD, 'K6', 'MRRURC', 'MRRFRC')" ).append("\n"); 
		query.append(",'MRDSRC')) AS COST_CD" ).append("\n"); 
		query.append("FROM MNR_EQ_CMPO_CD A, MNR_EQ_CMPO_CD B," ).append("\n"); 
		query.append("(SELECT @[eq_knd_cd] EQ_KND_CD,  @[tp_sz] TP_SZ, @[cmpo_cd] CMPO_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(") DM" ).append("\n"); 
		query.append("WHERE A.EQ_CMPO_GRP_TP_CD(+) = 3" ).append("\n"); 
		query.append("AND   A.EQ_PRNT_CMPO_GRP_TP_CD = B.EQ_CMPO_GRP_TP_CD(+)" ).append("\n"); 
		query.append("AND   A.EQ_PRNT_CMPO_CD        = B.EQ_CMPO_CD(+)" ).append("\n"); 
		query.append("AND   DM.CMPO_CD = A.EQ_CMPO_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") C" ).append("\n"); 
		query.append("GROUP BY C.EQ_CMPO_CD,C.EQ_CMPO_NM,C.COST_CD" ).append("\n"); 

	}
}