/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListUnplanCreateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.12
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2010.05.12 최종혁
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

public class SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListUnplanCreateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Unplaned S/O Candidate 선정
	  * </pre>
	  */
	public SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListUnplanCreateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("contract_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frmnode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frmnodeyard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ui_conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.integration").append("\n"); 
		query.append("FileName : SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListUnplanCreateRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("B.CTRL_OFC_CD" ).append("\n"); 
		query.append(", A.COP_NO" ).append("\n"); 
		query.append(", NVL(A.CNTR_NO, ' ') EQ_NO" ).append("\n"); 
		query.append(", A.CNTR_TPSZ_CD  AS EQ_TPSZ_CD" ).append("\n"); 
		query.append(", B.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append(", B.COST_ACT_GRP_CD" ).append("\n"); 
		query.append(", B.N1ST_VNDR_SEQ AS VNDR_SEQ" ).append("\n"); 
		query.append(", 'TD' TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append(", SUBSTR(B.N1ST_NOD_CD,1,5)  FM_NOD_CD" ).append("\n"); 
		query.append(", SUBSTR(B.N1ST_NOD_CD,6)    FM_NOD_YARD" ).append("\n"); 
		query.append(", TRS_CYDOOR_COMM_PKG.GET_SO_NODE_FNC('TO' , B.PCTL_IO_BND_CD, B.PCTL_COST_MOD_CD, B.N1ST_NOD_CD, B.N2ND_NOD_CD, B.N3RD_NOD_CD, B.N4TH_NOD_CD, 'NODE') TO_NOD_CD" ).append("\n"); 
		query.append(", TRS_CYDOOR_COMM_PKG.GET_SO_NODE_FNC('TO' , B.PCTL_IO_BND_CD, B.PCTL_COST_MOD_CD, B.N1ST_NOD_CD, B.N2ND_NOD_CD, B.N3RD_NOD_CD, B.N4TH_NOD_CD, 'YARD') TO_NOD_YARD" ).append("\n"); 
		query.append(", TRS_CYDOOR_COMM_PKG.GET_SO_NODE_FNC('VIA', B.PCTL_IO_BND_CD, B.PCTL_COST_MOD_CD, B.N1ST_NOD_CD, B.N2ND_NOD_CD, B.N3RD_NOD_CD, B.N4TH_NOD_CD, 'NODE') VIA_NOD_CD" ).append("\n"); 
		query.append(", TRS_CYDOOR_COMM_PKG.GET_SO_NODE_FNC('VIA', B.PCTL_IO_BND_CD, B.PCTL_COST_MOD_CD, B.N1ST_NOD_CD, B.N2ND_NOD_CD, B.N3RD_NOD_CD, B.N4TH_NOD_CD, 'YARD') VIA_NOD_YARD" ).append("\n"); 
		query.append(", TRS_CYDOOR_COMM_PKG.GET_SO_NODE_FNC('DOR', B.PCTL_IO_BND_CD, B.PCTL_COST_MOD_CD, B.N1ST_NOD_CD, B.N2ND_NOD_CD, B.N3RD_NOD_CD, B.N4TH_NOD_CD, 'NODE') DOR_NOD_CD" ).append("\n"); 
		query.append(", TRS_CYDOOR_COMM_PKG.GET_SO_NODE_FNC('DOR', B.PCTL_IO_BND_CD, B.PCTL_COST_MOD_CD, B.N1ST_NOD_CD, B.N2ND_NOD_CD, B.N3RD_NOD_CD, B.N4TH_NOD_CD, 'YARD') DOR_NOD_YARD" ).append("\n"); 
		query.append(", B.PCTL_IO_BND_CD AS TRSP_BND_CD" ).append("\n"); 
		query.append(", B.INLND_ROUT_INV_BIL_PATT_CD  AS RAIL_CMB_THRU_TP_CD" ).append("\n"); 
		query.append(", '' CUST_CNT_CD   -- B.CUST_CNT_CD" ).append("\n"); 
		query.append(", 0 CUST_SEQ   --B.CUST_SEQ" ).append("\n"); 
		query.append(", C.SC_NO" ).append("\n"); 
		query.append(", C.RFA_NO" ).append("\n"); 
		query.append(", B.TRSP_SO_STS_CD" ).append("\n"); 
		query.append(", DECODE(A.MST_COP_NO, A.COP_NO, 'P', 'X')   MST_LCL_CD" ).append("\n"); 
		query.append(", @[ui_conti_cd] AS FM_LOC_CONTI_CD" ).append("\n"); 
		query.append(", A.BKG_NO" ).append("\n"); 
		query.append(", TO_CHAR(B.N1ST_NOD_PLN_DT, 'YYYYMMDDHH24MISS') N1ST_NOD_PLN_DT" ).append("\n"); 
		query.append(", DECODE(B.PCTL_IO_BND_CD, 'I',C.DE_TERM_CD, 'O',C.RCV_TERM_CD, '')   BKG_RCVDE_TERM_CD" ).append("\n"); 
		query.append(", C.BL_NO" ).append("\n"); 
		query.append(", C.BKG_CGO_TP_CD" ).append("\n"); 
		query.append(", 'F' CGO_TP_CD" ).append("\n"); 
		query.append(", (C.VSL_CD||C.SKD_VOY_NO||C.SKD_DIR_CD) TRUNKVVD" ).append("\n"); 
		query.append(", C.SLAN_CD" ).append("\n"); 
		query.append(", C.POR_CD POR_CD" ).append("\n"); 
		query.append(", C.POL_CD POL_CD" ).append("\n"); 
		query.append(", C.POD_CD POD_CD" ).append("\n"); 
		query.append(", C.DEL_CD DEL_CD" ).append("\n"); 
		query.append(", C.CMDT_CD" ).append("\n"); 
		query.append(", B.DOR_ARR_DT" ).append("\n"); 
		query.append(", DECODE(B.PCTL_COST_MOD_CD,'C','CY','Z','DR','') TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append(", DECODE(B.PCTL_COST_MOD_CD, '', 'Y', '') UPLN_SO_FLG" ).append("\n"); 
		query.append(", COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00286',B.TRSP_SO_STS_CD)            TRSP_SO_STS_NM" ).append("\n"); 
		query.append("FROM SCE_COP_HDR A" ).append("\n"); 
		query.append(", PRD_PROD_CTL_ACT_GRP_DTL B" ).append("\n"); 
		query.append(", BKG_BOOKING C" ).append("\n"); 
		query.append("WHERE A.PCTL_NO=B.PCTL_NO" ).append("\n"); 
		query.append("AND A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($arr_so_office.size() > 0)" ).append("\n"); 
		query.append("AND B.CTRL_OFC_CD in (" ).append("\n"); 
		query.append("#foreach( ${key} in ${arr_so_office})" ).append("\n"); 
		query.append("#if($velocityCount < $arr_so_office.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND B.PCTL_COST_MOD_CD = 'X' AND A.CNTR_NO <> 'SMCU0000000'" ).append("\n"); 
		query.append("AND B.COST_ACT_GRP_TP_CD  = 'N'" ).append("\n"); 
		query.append("-- From Node의 Location으로 조회" ).append("\n"); 
		query.append("#if (${frmnode} != '')" ).append("\n"); 
		query.append("AND SUBSTR(B.N1ST_NOD_CD,1,5) = @[frmnode]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- From Node의 Yard로 조회" ).append("\n"); 
		query.append("#if (${frmnodeyard} != '')" ).append("\n"); 
		query.append("AND SUBSTR(B.N1ST_NOD_CD,6) = @[frmnodeyard]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- Booking no로 조회" ).append("\n"); 
		query.append("#if ($arr_bkgno.size() > 0)" ).append("\n"); 
		query.append("AND A.BKG_NO in (" ).append("\n"); 
		query.append("#foreach( ${key} in ${arr_bkgno})" ).append("\n"); 
		query.append("#if($velocityCount < $arr_bkgno.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- BL NO로 조회" ).append("\n"); 
		query.append("#if ($arr_billno.size() > 0)" ).append("\n"); 
		query.append("AND C.BL_NO in (" ).append("\n"); 
		query.append("#foreach( ${key} in ${arr_billno})" ).append("\n"); 
		query.append("#if($velocityCount < $arr_billno.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- Container no로 조회" ).append("\n"); 
		query.append("#if ($arr_cntrno.size() > 0)" ).append("\n"); 
		query.append("AND A.CNTR_NO in (" ).append("\n"); 
		query.append("#foreach( ${key} in ${arr_cntrno})" ).append("\n"); 
		query.append("#if($velocityCount < $arr_cntrno.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- Trunk VVD로 조회" ).append("\n"); 
		query.append("#if ($arr_trunkvvd.size() > 0)" ).append("\n"); 
		query.append("AND (C.VSL_CD,C.SKD_VOY_NO,C.SKD_DIR_CD) in (" ).append("\n"); 
		query.append("#foreach( ${key} in ${arr_trunkvvd})" ).append("\n"); 
		query.append("#if($velocityCount < $arr_trunkvvd.size())" ).append("\n"); 
		query.append("(SUBSTR('$key',1,4),SUBSTR('$key',5,4),SUBSTR('$key',9,1))," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("(SUBSTR('$key',1,4),SUBSTR('$key',5,4),SUBSTR('$key',9,1))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- Contract No로 조회" ).append("\n"); 
		query.append("#if (${contract_no} != '' )" ).append("\n"); 
		query.append("#if (${contract_tp_cd} == 'S' )" ).append("\n"); 
		query.append("AND C.SC_NO IN (@[contract_no])" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND C.RFA_NO IN (@[contract_no])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") AA WHERE 1=1" ).append("\n"); 

	}
}