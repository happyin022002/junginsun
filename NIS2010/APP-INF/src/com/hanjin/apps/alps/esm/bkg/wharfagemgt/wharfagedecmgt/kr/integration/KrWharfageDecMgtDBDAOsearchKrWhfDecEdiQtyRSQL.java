/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : KrWharfageDecMgtDBDAOsearchKrWhfDecEdiQtyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.13
*@LastModifier : 
*@LastVersion : 1.0
* 2013.05.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KrWharfageDecMgtDBDAOsearchKrWhfDecEdiQtyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S
	  * </pre>
	  */
	public KrWharfageDecMgtDBDAOsearchKrWhfDecEdiQtyRSQL(){
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
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whf_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration").append("\n"); 
		query.append("FileName : KrWharfageDecMgtDBDAOsearchKrWhfDecEdiQtyRSQL").append("\n"); 
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
		query.append(" SUM(A.VOL) AS EST_VOL" ).append("\n"); 
		query.append(",TRUNC(SUM(A.VOL* A.UNIT),0) AS SUM_AMOUNT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT SUM(A.TTL_TON_QTY) VOL , UNLD_TP_CD IND, KR_WHF_DC_CD DC ," ).append("\n"); 
		query.append("       KR_WHF_DC_RSN_CD REA," ).append("\n"); 
		query.append("       to_number(DECODE(UNLD_TP_CD, '6', DECODE(DECODE('OO','OT','4',KR_WHF_DC_CD),'1', B.C_20_UNIT_S," ).append("\n"); 
		query.append("                                                 '7',B.C_20_UNIT_S," ).append("\n"); 
		query.append("                                                 '4', '0'," ).append("\n"); 
		query.append("                                                 null, B.C_20_UNIT_F," ).append("\n"); 
		query.append("                                                 ' ', B.C_20_UNIT_F,'1')," ).append("\n"); 
		query.append("                          '8', DECODE(DECODE('OO','OT','4',KR_WHF_DC_CD),'1', B.C_40_UNIT_S," ).append("\n"); 
		query.append("                                                 '7',B.C_40_UNIT_S," ).append("\n"); 
		query.append("                                                 '4', '0'," ).append("\n"); 
		query.append("                                                 null, B.C_40_UNIT_F," ).append("\n"); 
		query.append("                                                 ' ', B.C_40_UNIT_F,'1')," ).append("\n"); 
		query.append("						  '9', DECODE(DECODE('OO','OT','4',KR_WHF_DC_CD),'1', B.C_45_UNIT_S," ).append("\n"); 
		query.append("                                                 '7',B.C_45_UNIT_S," ).append("\n"); 
		query.append("                                                 '4', '0'," ).append("\n"); 
		query.append("                                                 null, B.C_45_UNIT_F," ).append("\n"); 
		query.append("                                                 ' ', B.C_45_UNIT_F,'1')," ).append("\n"); 
		query.append("			  '5','2','7','2', DECODE(DECODE('OO','OT','4',KR_WHF_DC_CD)," ).append("\n"); 
		query.append("                                                 '4', '0'," ).append("\n"); 
		query.append("                                                 null, B.C_45_UNIT_F," ).append("\n"); 
		query.append("                                                 ' ', B.C_45_UNIT_F,'1'))) UNIT" ).append("\n"); 
		query.append("	  FROM BKG_KR_WHF_VVD_DTL A," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("         SELECT MAX(C_20_UNIT_S) C_20_UNIT_S," ).append("\n"); 
		query.append("                MAX(C_40_UNIT_S) C_40_UNIT_S," ).append("\n"); 
		query.append("                MAX(C_45_UNIT_S) C_45_UNIT_S," ).append("\n"); 
		query.append("                MAX(B_UNIT_S)    B_UNIT_S," ).append("\n"); 
		query.append("                MAX(C_20_UNIT_F) C_20_UNIT_F," ).append("\n"); 
		query.append("                MAX(C_40_UNIT_F) C_40_UNIT_F," ).append("\n"); 
		query.append("                MAX(C_45_UNIT_F) C_45_UNIT_F," ).append("\n"); 
		query.append("                MAX(B_UNIT_F)    B_UNIT_F" ).append("\n"); 
		query.append("           FROM (" ).append("\n"); 
		query.append("                 SELECT " ).append("\n"); 
		query.append("					DECODE(CNTR_BLK_DIV_CD,'C',TEU_PRC * (1-TEU_AMT_RT),0) C_20_UNIT_S," ).append("\n"); 
		query.append("					DECODE(CNTR_BLK_DIV_CD,'C',FEU_PRC * (1-FEU_AMT_RT),0) C_40_UNIT_S," ).append("\n"); 
		query.append("					DECODE(CNTR_BLK_DIV_CD,'C',HC_PRC  * (1-HC_AMT_RT),0) C_45_UNIT_S," ).append("\n"); 
		query.append("					DECODE(CNTR_BLK_DIV_CD,'B',TEU_PRC * (1-TEU_AMT_RT),0) B_UNIT_S," ).append("\n"); 
		query.append("					DECODE(CNTR_BLK_DIV_CD,'C',TEU_PRC ,0) C_20_UNIT_F," ).append("\n"); 
		query.append("					DECODE(CNTR_BLK_DIV_CD,'C',FEU_PRC ,0) C_40_UNIT_F," ).append("\n"); 
		query.append("					DECODE(CNTR_BLK_DIV_CD,'C',HC_PRC ,0) C_45_UNIT_F," ).append("\n"); 
		query.append("					DECODE(CNTR_BLK_DIV_CD,'B',TEU_PRC ,0) B_UNIT_F" ).append("\n"); 
		query.append("					FROM BKG_KR_WHF_PORT_RT A, BKG_KR_WHF_VOL B, VSK_VSL_PORT_SKD S" ).append("\n"); 
		query.append("					WHERE 1=1" ).append("\n"); 
		query.append("					AND A.CNTR_BLK_DIV_CD    IN ('C','B')" ).append("\n"); 
		query.append("					AND A.PORT_CD    = @[port_cd]" ).append("\n"); 
		query.append("					AND A.IO_BND_CD = SUBSTR(@[whf_bnd_cd],1,1)" ).append("\n"); 
		query.append("					AND ( A.DC_RTO_NO, A.CNTR_BLK_DIV_CD ) in ( SELECT NVL(TRIM(MAX(DC_RTO_NO)),'0') , CNTR_BLK_DIV_CD" ).append("\n"); 
		query.append("															FROM BKG_KR_WHF_PORT_RT" ).append("\n"); 
		query.append("															WHERE 1=1" ).append("\n"); 
		query.append("															AND CNTR_BLK_DIV_CD    IN ('C','B')" ).append("\n"); 
		query.append("															AND PORT_CD     = @[port_cd]" ).append("\n"); 
		query.append("															AND IO_BND_CD   = SUBSTR(@[whf_bnd_cd],1,1)" ).append("\n"); 
		query.append("															AND DC_RTO_NO   = B.WHF_VOL_DC_CD" ).append("\n"); 
		query.append("															GROUP BY CNTR_BLK_DIV_CD )" ).append("\n"); 
		query.append("					AND B.VSL_CD      = SUBSTR( @[vvd],1,4 )" ).append("\n"); 
		query.append("					AND B.SKD_VOY_NO  = SUBSTR( @[vvd],5,4 )" ).append("\n"); 
		query.append("					AND B.SKD_DIR_CD  = SUBSTR( @[vvd],9,1 )" ).append("\n"); 
		query.append("					AND B.WHF_BND_CD  = @[whf_bnd_cd]" ).append("\n"); 
		query.append("					AND B.PORT_CD     = A.PORT_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					AND S.VSL_CD = SUBSTR( @[vvd], 1, 4)" ).append("\n"); 
		query.append("                    AND S.SKD_VOY_NO = SUBSTR( @[vvd], 5, 4)" ).append("\n"); 
		query.append("                    AND S.SKD_DIR_CD = SUBSTR( @[vvd], 9, 1)" ).append("\n"); 
		query.append("                    AND S.VPS_PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("                    AND S.CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("                    AND DECODE( SUBSTR(@[whf_bnd_cd],1,1), 'I', S.VPS_ETA_DT, S.VPS_ETD_DT) between EFF_FM_DT and EFF_TO_DT + 0.99999" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("       ) B" ).append("\n"); 
		query.append(" WHERE VSL_CD         = SUBSTR( @[vvd],1,4 )" ).append("\n"); 
		query.append("   AND SKD_VOY_NO     = SUBSTR( @[vvd],5,4 )" ).append("\n"); 
		query.append("   AND SKD_DIR_CD     = SUBSTR( @[vvd],9,1 )" ).append("\n"); 
		query.append("   AND PORT_CD        = @[port_cd]" ).append("\n"); 
		query.append("   AND WHF_BND_CD     = @[whf_bnd_cd]" ).append("\n"); 
		query.append(" GROUP BY  UNLD_TP_CD, KR_WHF_DC_CD," ).append("\n"); 
		query.append("       KR_WHF_DC_RSN_CD," ).append("\n"); 
		query.append("       to_number(DECODE(UNLD_TP_CD, '6', DECODE(DECODE('OO','OT','4',KR_WHF_DC_CD),'1', B.C_20_UNIT_S," ).append("\n"); 
		query.append("                                                 '7',B.C_20_UNIT_S," ).append("\n"); 
		query.append("                                                 '4', '0'," ).append("\n"); 
		query.append("                                                 null, B.C_20_UNIT_F," ).append("\n"); 
		query.append("                                                 ' ', B.C_20_UNIT_F,'1')," ).append("\n"); 
		query.append("                          '8', DECODE(DECODE('OO','OT','4',KR_WHF_DC_CD),'1', B.C_40_UNIT_S," ).append("\n"); 
		query.append("                                                 '7',B.C_40_UNIT_S," ).append("\n"); 
		query.append("                                                 '4', '0'," ).append("\n"); 
		query.append("                                                 null, B.C_40_UNIT_F," ).append("\n"); 
		query.append("                                                 ' ', B.C_40_UNIT_F,'1')," ).append("\n"); 
		query.append("						  '9', DECODE(DECODE('OO','OT','4',KR_WHF_DC_CD),'1', B.C_45_UNIT_S," ).append("\n"); 
		query.append("                                                 '7',B.C_45_UNIT_S," ).append("\n"); 
		query.append("                                                 '4', '0'," ).append("\n"); 
		query.append("                                                 null, B.C_45_UNIT_F," ).append("\n"); 
		query.append("                                                 ' ', B.C_45_UNIT_F,'1')," ).append("\n"); 
		query.append("			  '5','2','7','2', DECODE(DECODE('OO','OT','4',KR_WHF_DC_CD)," ).append("\n"); 
		query.append("                                                 '4', '0'," ).append("\n"); 
		query.append("                                                 null, B.C_45_UNIT_F," ).append("\n"); 
		query.append("                                                 ' ', B.C_45_UNIT_F,'1')))" ).append("\n"); 
		query.append(") A" ).append("\n"); 

	}
}