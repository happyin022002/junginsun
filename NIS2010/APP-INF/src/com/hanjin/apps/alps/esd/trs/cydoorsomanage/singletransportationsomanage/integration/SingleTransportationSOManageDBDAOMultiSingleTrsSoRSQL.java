/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SingleTransportationSOManageDBDAOMultiSingleTrsSoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.06
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2011.07.06 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JH CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SingleTransportationSOManageDBDAOMultiSingleTrsSoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CY & Door SO가 발급된 북킹, COP번호를 조회
	  * </pre>
	  */
	public SingleTransportationSOManageDBDAOMultiSingleTrsSoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_act_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.integration").append("\n"); 
		query.append("FileName : SingleTransportationSOManageDBDAOMultiSingleTrsSoRSQL").append("\n"); 
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
		query.append("('COP No:'||COP_NO||', BKG No:'||BKG_NO||', CNTR No:'||EQ_NO) CHK_UNIT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("TRS_TRSP_RAIL_BIL_ORD" ).append("\n"); 
		query.append("WHERE COP_NO = @[cop_no]" ).append("\n"); 
		query.append("AND COST_ACT_GRP_SEQ = @[cost_act_grp_seq]" ).append("\n"); 
		query.append("AND DELT_FLG                 = 'N'" ).append("\n"); 
		query.append("AND NVL(TRSP_FRST_FLG,'N')   = 'N'" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("('COP No:'||COP_NO||', BKG No:'||BKG_NO||', CNTR No:'||EQ_NO) CHK_UNIT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("WHERE COP_NO = @[cop_no]" ).append("\n"); 
		query.append("AND COST_ACT_GRP_SEQ = @[cost_act_grp_seq]" ).append("\n"); 
		query.append("AND DELT_FLG                 = 'N'" ).append("\n"); 
		query.append("AND NVL(TRSP_FRST_FLG,'N')   = 'N'" ).append("\n"); 
		query.append("AND NVL(RPLN_UMCH_FLG,'N')   = 'N'" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("('COP No:'||COP_NO||', BKG No:'||BKG_NO||', CNTR No:'||EQ_NO) CHK_UNIT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("WHERE COP_NO = @[cop_no]" ).append("\n"); 
		query.append("AND FM_NOD_CD = @[fm_nod_cd]" ).append("\n"); 
		query.append("AND TO_NOD_CD = @[to_nod_cd]" ).append("\n"); 
		query.append("AND DELT_FLG                 = 'N'" ).append("\n"); 
		query.append("AND NVL(TRSP_FRST_FLG,'N')   = 'N'" ).append("\n"); 
		query.append("AND NVL(RPLN_UMCH_FLG,'N')   = 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${trsp_cost_dtl_mode_cd} == 'DOOR' )" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT ('COP No:'||COP_NO||', BKG No:'||BKG_NO||', CNTR No:'||EQ_NO) CHK_UNIT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("WHERE COP_NO = @[cop_no]" ).append("\n"); 
		query.append("AND TRSP_COST_DTL_MOD_CD   = 'DR'" ).append("\n"); 
		query.append("AND TRSP_BND_CD          = @[trsp_bnd_cd]" ).append("\n"); 
		query.append("AND DELT_FLG               = 'N'" ).append("\n"); 
		query.append("#if (${ui_conti_cd} == 'E' )" ).append("\n"); 
		query.append("AND TRO_SEQ = @[tro_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}