/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOSearchAutoTrdPartyVolumeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.12
*@LastModifier : 
*@LastVersion : 1.0
* 2013.12.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalInvoiceManageDBDAOSearchAutoTrdPartyVolumeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAutoTrdPartyVolume
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOSearchAutoTrdPartyVolumeRSQL(){
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
		params.put("lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_trns_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tml_wrk_dy_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcgo_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ioc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOSearchAutoTrdPartyVolumeRSQL").append("\n"); 
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
		query.append("	        T.TML_IF_OFC_CD,  --TRD KEY" ).append("\n"); 
		query.append("	        T.TML_IF_SEQ,  --TRD KEY" ).append("\n"); 
		query.append("	        @[lgs_cost_cd]	LGS_COST_CD," ).append("\n"); 
		query.append("	        DECODE(T.CNTR_NO,'','0','1') CHK," ).append("\n"); 
		query.append("	        H.TML_INV_TP_CD," ).append("\n"); 
		query.append("	        H.INV_NO," ).append("\n"); 
		query.append("	        LPAD(H.VNDR_SEQ, 6, '0') VNDR_SEQ," ).append("\n"); 
		query.append("	        H.YD_CD," ).append("\n"); 
		query.append("	        H.TML_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("	        H.TML_SO_SEQ," ).append("\n"); 
		query.append("	        C.CNTR_NO," ).append("\n"); 
		query.append("	        C.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("	        C.BKG_NO," ).append("\n"); 
		query.append("	        C.BL_NO," ).append("\n"); 
		query.append("	        C.IO_BND_CD," ).append("\n"); 
		query.append("	        H.CURR_CD," ).append("\n"); 
		query.append("	        H.ERR_INV_NO," ).append("\n"); 
		query.append("	        T.IF_AMT," ).append("\n"); 
		query.append("	        T.IF_RMK," ).append("\n"); 
		query.append("	        T.VNDR_CUST_DIV_CD," ).append("\n"); 
		query.append("	        T.VNDR_CNT_CD," ).append("\n"); 
		query.append("	        T.N3PTY_VNDR_SEQ," ).append("\n"); 
		query.append("	        T.CUST_CNT_CD," ).append("\n"); 
		query.append("	        T.CUST_SEQ," ).append("\n"); 
		query.append("	        T.N3PTY_OFC_CD," ).append("\n"); 
		query.append("	        CASE WHEN T.N3PTY_BIL_TP_CD IS NULL THEN" ).append("\n"); 
		query.append("/*  TPB Billing case (AW)에 대한 IF 오류 수정  ( 2009-09-18 )   " ).append("\n"); 
		query.append("	TPB_N3RD_PTY_BIL_TP 와 조인해서 사용하지 않는 코드일 경우 가져오지 않고 Default 는 없는것으로 수정.	        	" ).append("\n"); 
		query.append("				(SELECT" ).append("\n"); 
		query.append("	        	 		CASE WHEN A.CNT IS NOT NULL AND A.CNT>=1 THEN A.N3PTY_BIL_CS_CD" ).append("\n"); 
		query.append("	        	 		ELSE 'CY' END N3PTY_BIL_CS_CD" ).append("\n"); 
		query.append("	        	 FROM (" ).append("\n"); 
		query.append("	        	 		SELECT" ).append("\n"); 
		query.append("	        	 			(SELECT COUNT(N3PTY_BIL_CS_CD)" ).append("\n"); 
		query.append("							 FROM TES_TML_N3RD_PTY_COST  WHERE LGS_COST_CD=[lgs_cost_cd]) CNT," ).append("\n"); 
		query.append("	        	 			(SELECT N3PTY_BIL_CS_CD" ).append("\n"); 
		query.append("							 FROM TES_TML_N3RD_PTY_COST WHERE LGS_COST_CD=[lgs_cost_cd]) N3PTY_BIL_CS_CD" ).append("\n"); 
		query.append("	        	 		FROM DUAL" ).append("\n"); 
		query.append("	        	 ) A)" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("				(SELECT  CASE WHEN CNT IS NOT NULL AND CNT >= 1 THEN N3PTY_BIL_CS_CD END N3PTY_BIL_CS_CD" ).append("\n"); 
		query.append("				FROM    (" ).append("\n"); 
		query.append("						SELECT  COUNT(N3PTY_BIL_CS_CD) CNT, N3PTY_BIL_CS_CD" ).append("\n"); 
		query.append("						FROM    TES_TML_N3RD_PTY_COST A, TPB_N3RD_PTY_BIL_TP B" ).append("\n"); 
		query.append("						WHERE   1   = 1" ).append("\n"); 
		query.append("						AND     A.N3PTY_BIL_CS_CD   = B.N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append("						AND     A.LGS_COST_CD       = @[lgs_cost_cd]" ).append("\n"); 
		query.append("						AND     B.ACT_FLG           = 'Y'" ).append("\n"); 
		query.append("						AND     B.N3PTY_BIL_TP_CD   != 'JO'" ).append("\n"); 
		query.append("						GROUP BY N3PTY_BIL_CS_CD" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("	        ELSE T.N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append("	        END N3PTY_BIL_TP_CD," ).append("\n"); 
		query.append("	        CASE" ).append("\n"); 
		query.append("	        WHEN T.VNDR_CUST_DIV_CD = 'C' THEN ''||T.CUST_SEQ" ).append("\n"); 
		query.append("	        WHEN T.VNDR_CUST_DIV_CD = 'S' THEN T.N3PTY_OFC_CD" ).append("\n"); 
		query.append("	        WHEN T.VNDR_CUST_DIV_CD = 'V' THEN ''||T.N3PTY_VNDR_SEQ" ).append("\n"); 
		query.append("	        END POP_VALUE" ).append("\n"); 
		query.append("	FROM TES_TML_SO_HDR H, TES_TML_SO_CNTR_LIST C, TES_N3RD_PTY_IF T" ).append("\n"); 
		query.append("	WHERE 1=1" ).append("\n"); 
		query.append("	AND H.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("	AND H.TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 
		query.append("	AND H.TML_SO_OFC_CTY_CD = C.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("	AND H.TML_SO_SEQ        = C.TML_SO_SEQ" ).append("\n"); 
		query.append("	AND C.TML_SO_OFC_CTY_CD = T.TML_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("	AND C.TML_SO_SEQ        = T.TML_SO_SEQ(+)" ).append("\n"); 
		query.append("    AND T.LGS_COST_CD(+) = @[lgs_cost_cd]   /* 2013.12.12 양양선 부장 요청으로 수정. 동일한 CNTR이 상이한 Cost Code를 갖는 경우, 각각의 Cost code별 비용을 Assign하고, 3rd Party Billing시 각각의 값을 TPB로 I/F 하기위함 */" ).append("\n"); 
		query.append("	AND C.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("	AND C.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("	AND C.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("	AND C.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("	AND C.VRFY_RSLT_IND_CD = 'CO'" ).append("\n"); 
		query.append("	AND C.CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("	AND C.CNTR_NO = T.CNTR_NO(+)" ).append("\n"); 
		query.append("	AND NVL(C.CNTR_TPSZ_CD,'N') = NVL(@[cntr_tpsz_cd],'N')" ).append("\n"); 
		query.append("	AND NVL(C.IO_BND_CD,'N') 	= NVL(@[io_bnd_cd],'N')" ).append("\n"); 
		query.append("	AND NVL(C.DCGO_CLSS_CD,'N') = NVL(@[dcgo_ind_cd],'N')" ).append("\n"); 
		query.append("	AND NVL(C.IOC_CD,'S') 		= NVL(@[ioc_cd],'S')" ).append("\n"); 
		query.append("	AND NVL(C.LANE_CD,'OTH') 		= NVL(@[lane_cd],'OTH')" ).append("\n"); 
		query.append("	AND DECODE(@[tml_trns_mod_cd],'','S','S','S',NVL(TML_TRNS_MOD_CD,'S')) = NVL(@[tml_trns_mod_cd],'S')" ).append("\n"); 
		query.append("	AND DECODE(C.BB_CGO_FLG,'Y','BB',DECODE(C.LOCL_TS_IND_CD,'T',DECODE(C.CNTR_STY_CD,'F','TS','TM'),DECODE(C.CNTR_STY_CD,'F','FL','MT'))) = SUBSTR(@[lgs_cost_cd],5,2)" ).append("\n"); 
		query.append("	AND DECODE((SELECT COUNT(*)" ).append("\n"); 
		query.append("        		 FROM   DMT_HOLIDAY" ).append("\n"); 
		query.append("        		 WHERE  TO_CHAR(HOL_DT,'YYYYMMDD')    = TO_CHAR(WRK_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("	      		 AND    CNT_CD    = SUBSTR(@[yd_cd],1,2)" ).append("\n"); 
		query.append("	      		  ), 0, DECODE(TO_CHAR(C.WRK_DT,'D'),7,'SA',1,'SU','WD'),'HO') = NVL(@[tml_wrk_dy_cd],'WD')" ).append("\n"); 
		query.append("	AND NVL(T.CXL_FLG,'N') = 'N'" ).append("\n"); 

	}
}