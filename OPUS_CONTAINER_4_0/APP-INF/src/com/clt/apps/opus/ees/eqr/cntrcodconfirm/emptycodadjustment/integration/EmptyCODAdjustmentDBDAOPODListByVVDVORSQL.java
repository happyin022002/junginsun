/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EmptyCODAdjustmentDBDAOPODListByVVDVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2009.08.11 박광석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Prak Kwang Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyCODAdjustmentDBDAOPODListByVVDVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public EmptyCODAdjustmentDBDAOPODListByVVDVORSQL(){
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
		params.put("targetweek",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cim.cntrcodconfirm.emptycodadjustment.integration").append("\n"); 
		query.append("FileName : EmptyCODAdjustmentDBDAOPODListByVVDVORSQL").append("\n"); 
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
		query.append("SELECT	VS.VPS_PORT_CD	pod					,		/* POD				*/" ).append("\n"); 
		query.append("TO_CHAR(VS.VPS_ETB_DT,'YYYYMMDD')||'&&'||			/* ETB				*/" ).append("\n"); 
		query.append("WK.PLN_YR||WK.PLN_WK||'&&'||						/* ETB_WEEK			*/" ).append("\n"); 
		query.append("DECODE( WK.PLN_YR||WK.PLN_WK,	DV.L2,	'1'," ).append("\n"); 
		query.append("DV.L1,	'2'," ).append("\n"); 
		query.append("DV.M0,	'3'," ).append("\n"); 
		query.append("DV.R1,	'4'," ).append("\n"); 
		query.append("DV.R2,	'5'," ).append("\n"); 
		query.append("NULL)||'&&'|| VS.VPS_PORT_CD etb" ).append("\n"); 
		query.append("/* ETB_WEEK_DIVISION */" ).append("\n"); 
		query.append("FROM	VSK_VSL_PORT_SKD	VS," ).append("\n"); 
		query.append("EQR_WK_PRD			WK," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT	L2, L1, M0, R1, R2" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("LAG(PLN_YR||PLN_WK,2)		OVER (ORDER BY PLN_YR,PLN_WK)	L2," ).append("\n"); 
		query.append("LAG(PLN_YR||PLN_WK,1)		OVER (ORDER BY PLN_YR,PLN_WK)	L1," ).append("\n"); 
		query.append("PLN_YR||PLN_WK										        M0," ).append("\n"); 
		query.append("LEAD(PLN_YR||PLN_WK,1)		OVER (ORDER BY PLN_YR,PLN_WK)	R1," ).append("\n"); 
		query.append("LEAD(PLN_YR||PLN_WK,2)		OVER (ORDER BY PLN_YR,PLN_WK)	R2" ).append("\n"); 
		query.append("FROM	EQR_WK_PRD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE	M0	=	@[targetweek]		/* ________________ ( Parameter Week ) */" ).append("\n"); 
		query.append(")					DV," ).append("\n"); 
		query.append("MDM_COUNTRY			CNT," ).append("\n"); 
		query.append("MDM_SUBCONTINENT	SCNT" ).append("\n"); 
		query.append("WHERE	VS.VSL_CD			=	SUBSTR(@[vvd],0,4)		/* ________________ ( Parameter VVD )	*/" ).append("\n"); 
		query.append("AND		VS.SKD_VOY_NO		=	SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND		VS.SKD_DIR_CD		=	SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND		TO_CHAR(VS.VPS_ETB_DT,'YYYYMMDD')	BETWEEN		WK.WK_ST_DT" ).append("\n"); 
		query.append("AND			WK.WK_END_DT" ).append("\n"); 
		query.append("AND		CNT.CNT_CD			=	SUBSTR(VS.VPS_PORT_CD, 1, 2)" ).append("\n"); 
		query.append("AND		CNT.SCONTI_CD		=	SCNT.SCONTI_CD" ).append("\n"); 
		query.append("AND     SCNT.CONTI_CD		=	'A'" ).append("\n"); 

	}
}