/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CopDetailReceiveDBDAOUpdateInlandDwellPodUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.31
*@LastModifier : 
*@LastVersion : 1.0
* 2013.10.31 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.copdetailreceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOUpdateInlandDwellPodUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * POD 지역 Inland Plan Date 업데이트
	  * </pre>
	  */
	public CopDetailReceiveDBDAOUpdateInlandDwellPodUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_act_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_cop_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOUpdateInlandDwellPodUSQL").append("\n"); 
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
		query.append("UPDATE	SCE_COP_DTL  D " ).append("\n"); 
		query.append("SET	    D.FX_PLN_DT =  " ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			SELECT  " ).append("\n"); 
		query.append("					CASE    WHEN D.ACT_CD IN ( 'FUVMUD', 'FUWMUD' )           THEN " ).append("\n"); 
		query.append("									TO_DATE(@[aft_act_dt],'YYYY/MM/DD HH24:MI:SS')" ).append("\n"); 
		query.append("							WHEN D.ACT_CD IN ( 'FUWMLO', 'FIRRLO','FIWMLO')   THEN" ).append("\n"); 
		query.append("									SCE_COP_SKD_LGC_CAL_FNC(L.COP_FOML_CD,  Y.DWLL_HRS,  NULL, TO_DATE(@[aft_act_dt],'YYYY/MM/DD HH24:MI:SS') + NUMTODSINTERVAL(NVL(Y.DWLL_HRS,0),'HOUR'), L.FOML_PCT_NO, L.FOML_TM_HRS)" ).append("\n"); 
		query.append("							WHEN D.ACT_CD LIKE '____DO'                       THEN" ).append("\n"); 
		query.append("									TO_DATE(@[aft_act_dt],'YYYY/MM/DD HH24:MI:SS') + NUMTODSINTERVAL(NVL(Y.DWLL_HRS,0),'HOUR')" ).append("\n"); 
		query.append("							ELSE" ).append("\n"); 
		query.append("								 D.PLN_DT                            " ).append("\n"); 
		query.append("					END    " ).append("\n"); 
		query.append("			FROM    MDM_ACTIVITY        A," ).append("\n"); 
		query.append("					SCE_COP_SKD_LGC     L," ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						SELECT  DECODE ( SUBSTR( @[cntr_tpsz_cd],1,1 ), 'R', Y.COP_IB_RF_AVG_DWLL_HRS," ).append("\n"); 
		query.append("																			  COP_IB_DRY_AVG_DWLL_HRS ) DWLL_HRS   " ).append("\n"); 
		query.append("						FROM    MDM_YARD    Y" ).append("\n"); 
		query.append("						WHERE   Y.YD_CD             =   @[nod_cd]       " ).append("\n"); 
		query.append("					)                   Y" ).append("\n"); 
		query.append("			WHERE   D.ACT_CD            =   A.ACT_CD" ).append("\n"); 
		query.append("			AND     A.COP_SKD_LGC_NO    =   L.COP_SKD_LGC_NO (+)  " ).append("\n"); 
		query.append("		)			            " ).append("\n"); 
		query.append("WHERE	D.COP_NO		=	@[cop_no]" ).append("\n"); 
		query.append("AND	D.COP_DTL_SEQ		>=	@[fm_cop_dtl_seq]" ).append("\n"); 
		query.append("AND     D.NOD_CD        =   @[nod_cd]" ).append("\n"); 

	}
}