/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOSearchManualTrdPartyVolumeJoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.10
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2010.02.10 박재흥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author park chae heung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalInvoiceManageDBDAOSearchManualTrdPartyVolumeJoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchManualTrdPartyVolumeJo
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOSearchManualTrdPartyVolumeJoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOSearchManualTrdPartyVolumeJoRSQL").append("\n"); 
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
		query.append("T.TML_IF_OFC_CD,  --TRD KEY" ).append("\n"); 
		query.append("T.TML_IF_SEQ,	--TRD KEY" ).append("\n"); 
		query.append("@[lgs_cost_cd]	LGS_COST_CD," ).append("\n"); 
		query.append("DECODE(NVL(T.CNTR_NO,'0'),'0','0','1') CHK," ).append("\n"); 
		query.append("H.TML_INV_TP_CD," ).append("\n"); 
		query.append("H.INV_NO," ).append("\n"); 
		query.append("LPAD(H.VNDR_SEQ, 6, '0') VNDR_SEQ," ).append("\n"); 
		query.append("H.YD_CD," ).append("\n"); 
		query.append("H.TML_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("H.TML_SO_SEQ," ).append("\n"); 
		query.append("T.CNTR_NO," ).append("\n"); 
		query.append("T.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("T.IO_BND_CD," ).append("\n"); 
		query.append("H.CURR_CD," ).append("\n"); 
		query.append("H.ERR_INV_NO," ).append("\n"); 
		query.append("T.IF_AMT," ).append("\n"); 
		query.append("T.IF_RMK," ).append("\n"); 
		query.append("T.VNDR_CUST_DIV_CD," ).append("\n"); 
		query.append("T.VNDR_CNT_CD," ).append("\n"); 
		query.append("T.N3PTY_VNDR_SEQ," ).append("\n"); 
		query.append("T.CUST_CNT_CD," ).append("\n"); 
		query.append("T.CUST_SEQ," ).append("\n"); 
		query.append("T.N3PTY_OFC_CD," ).append("\n"); 
		query.append("CASE WHEN T.N3PTY_BIL_TP_CD IS NULL THEN" ).append("\n"); 
		query.append("/*			TPB Billing case (AW)에 대한 IF 오류 수정  ( 2009-09-18 )" ).append("\n"); 
		query.append("TPB_N3RD_PTY_BIL_TP 와 조인해서 사용하지 않는 코드일 경우 가져오지 않고 Default 는 없는것으로 수정." ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("CASE WHEN A.CNT IS NOT NULL AND A.CNT>=1" ).append("\n"); 
		query.append("THEN A.N3PTY_BIL_CS_CD" ).append("\n"); 
		query.append("ELSE 'CY' END N3PTY_BIL_CS_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("(SELECT COUNT(N3PTY_BIL_CS_CD)" ).append("\n"); 
		query.append("FROM TES_TML_N3RD_PTY_COST" ).append("\n"); 
		query.append("WHERE LGS_COST_CD=[lgs_cost_cd]) CNT," ).append("\n"); 
		query.append("(SELECT N3PTY_BIL_CS_CD" ).append("\n"); 
		query.append("FROM TES_TML_N3RD_PTY_COST" ).append("\n"); 
		query.append("WHERE LGS_COST_CD=[lgs_cost_cd]) N3PTY_BIL_CS_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(") A)" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("(SELECT  CASE WHEN CNT IS NOT NULL AND CNT >= 1" ).append("\n"); 
		query.append("THEN N3PTY_BIL_CS_CD END N3PTY_BIL_CS_CD" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  COUNT(N3PTY_BIL_CS_CD) CNT, N3PTY_BIL_CS_CD" ).append("\n"); 
		query.append("FROM    TES_TML_N3RD_PTY_COST A, TPB_N3RD_PTY_BIL_TP B" ).append("\n"); 
		query.append("WHERE   1   = 1" ).append("\n"); 
		query.append("AND     A.N3PTY_BIL_CS_CD   = B.N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append("AND     A.LGS_COST_CD       = @[lgs_cost_cd]" ).append("\n"); 
		query.append("AND     B.ACT_FLG           = 'Y'" ).append("\n"); 
		query.append("AND     B.N3PTY_BIL_TP_CD   != 'JO'" ).append("\n"); 
		query.append("GROUP BY N3PTY_BIL_CS_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ELSE T.N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append("END N3PTY_BIL_TP_CD," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN T.VNDR_CUST_DIV_CD = 'C' THEN ''||T.CUST_SEQ" ).append("\n"); 
		query.append("WHEN T.VNDR_CUST_DIV_CD = 'S' THEN T.N3PTY_OFC_CD" ).append("\n"); 
		query.append("WHEN T.VNDR_CUST_DIV_CD = 'V' THEN ''||T.N3PTY_VNDR_SEQ" ).append("\n"); 
		query.append("END POP_VALUE" ).append("\n"); 
		query.append("FROM TES_TML_SO_HDR H, TES_N3RD_PTY_IF T" ).append("\n"); 
		query.append("WHERE  H.TML_SO_OFC_CTY_CD = T.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND    H.TML_SO_SEQ = T.TML_SO_SEQ" ).append("\n"); 
		query.append("AND    H.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND    H.TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 
		query.append("AND    T.LGS_COST_CD = @[lgs_cost_cd]" ).append("\n"); 
		query.append("AND    T.TML_SO_DTL_SEQ = NVL(@[tml_so_dtl_seq],0)" ).append("\n"); 
		query.append("AND    NVL(T.CXL_FLG,'N') = 'N'" ).append("\n"); 
		query.append("ORDER BY T.CNTR_NO, T.CNTR_TPSZ_CD, T.IO_BND_CD" ).append("\n"); 

	}
}