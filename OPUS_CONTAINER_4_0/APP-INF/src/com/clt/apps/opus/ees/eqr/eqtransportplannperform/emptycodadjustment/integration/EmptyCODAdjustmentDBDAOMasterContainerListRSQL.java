/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EmptyCODAdjustmentDBDAOMasterContainerListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.21
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyCODAdjustmentDBDAOMasterContainerListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MTY 양하 계획 조정
	  * EES_CIM_1058
	  * HR/ DMG MTY CNTR List
	  * </pre>
	  */
	public EmptyCODAdjustmentDBDAOMasterContainerListRSQL(){
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
		query.append("Path : com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.integration").append("\n"); 
		query.append("FileName : EmptyCODAdjustmentDBDAOMasterContainerListRSQL").append("\n"); 
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
		query.append("SELECT	" ).append("\n"); 
		query.append("		BP.CNTR_REF_NO			," ).append("\n"); 
		query.append("		CM.CNTR_TPSZ_CD			," ).append("\n"); 
		query.append("		BP.POL_CD				," ).append("\n"); 
		query.append("		BP.POD_CD				," ).append("\n"); 
		query.append("		BP.VSL_BAY_NO||BP.VSL_ROW_NO||BP.VSL_TR_NO		BAY_NO," ).append("\n"); 
		query.append("		NVL(CM.CNTR_HNGR_BAR_ATCH_KNT,0) XXX," ).append("\n"); 
		query.append("		BK.BKG_NO" ).append("\n"); 
		query.append("FROM	" ).append("\n"); 
		query.append("		OPF_BAY_PLN_LDIS	BP, " ).append("\n"); 
		query.append("		BKG_VVD				BV," ).append("\n"); 
		query.append("		BKG_BOOKING			BK," ).append("\n"); 
		query.append("		BKG_CONTAINER		BC," ).append("\n"); 
		query.append("		MST_CONTAINER		CM" ).append("\n"); 
		query.append("WHERE	BP.VSL_CD				=	SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND		BP.SKD_VOY_NO			=	SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND		BP.SKD_DIR_CD			=	SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND		BP.POD_CD				=	DECODE(@[pod],'',BP.POD_CD,@[pod])" ).append("\n"); 
		query.append("AND		BP.LODG_DCHG_IND_CD		=	'C'" ).append("\n"); 
		query.append("AND		BP.FULL_MTY_CD			=	'E'" ).append("\n"); 
		query.append("AND		BP.CRR_CD	=	(SELECT COM_CONSTANTMGR_PKG. COM_GETCOMPANYCODE_FNC" ).append("\n"); 
		query.append("						 FROM DUAL)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND		BP.VSL_CD			=	BV.VSL_CD" ).append("\n"); 
		query.append("AND		BP.SKD_VOY_NO		=	BV.SKD_VOY_NO" ).append("\n"); 
		query.append("AND		BP.SKD_DIR_CD		=	BV.SKD_DIR_CD" ).append("\n"); 
		query.append("AND		BV.BKG_NO			=	BK.BKG_NO" ).append("\n"); 
		query.append("AND		BK.BKG_NO			=	BC.BKG_NO" ).append("\n"); 
		query.append("AND		BC.CNTR_NO			=	BP.CNTR_REF_NO" ).append("\n"); 
		query.append("#if ( ${version} == 'H' )" ).append("\n"); 
		query.append("AND     CM.CNTR_HNGR_RCK_CD IS NOT NULL                 /* 2010.03.15 By SBKIM */" ).append("\n"); 
		query.append("--AND		NVL(CM.CNTR_HNGR_BAR_ATCH_KNT,0)  > 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${version} == 'D' )" ).append("\n"); 
		query.append("AND		CM.DMG_FLG		=	'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND		BC.CNTR_NO			=	CM.CNTR_NO" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("		BP.CNTR_REF_NO" ).append("\n"); 

	}
}