/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChangeOfDestinationMgtDBDAORehandlingRateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.09.02 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jong Ock
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChangeOfDestinationMgtDBDAORehandlingRateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dummy
	  * </pre>
	  */
	public ChangeOfDestinationMgtDBDAORehandlingRateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tpsz",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration ").append("\n"); 
		query.append("FileName : ChangeOfDestinationMgtDBDAORehandlingRateRSQL").append("\n"); 
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
		query.append("SELECT DECODE(NVL(SUM(F.DVS_FEE_AMT),0),0,'RLO','DVC')                CHG_CD," ).append("\n"); 
		query.append("DECODE(NVL(SUM(F.DVS_FEE_AMT),0),0,@[curr_cd],'USD')           CURR_CD, --:cur" ).append("\n"); 
		query.append("DECODE(NVL(SUM(F.DVS_FEE_AMT),0),0,@[rate],SUM(F.DVS_FEE_AMT)) CHG_UT_AMT --, --:rate" ).append("\n"); 
		query.append("--       :tpsz                                                        TPSZ, --:tpsz" ).append("\n"); 
		query.append("--       :qty                                                         QTY,  --:qty" ).append("\n"); 
		query.append("--       :qty * :rate                                                 AMT  --:qty, :rate" ).append("\n"); 
		query.append("FROM   BKG_COD C, MDM_LOCATION L, OPF_COD_DVS_FEE F, GL_MON_XCH_RT G, VSK_VSL_PORT_SKD V, VSK_VSL_PORT_SKD S, MDM_LOCATION M" ).append("\n"); 
		query.append("WHERE  C.BKG_NO            = @[bkg_no]               --:bkg_no" ).append("\n"); 
		query.append("AND    C.COD_RQST_SEQ      = @[cod_rqst_seq]                   --:req_seq" ).append("\n"); 
		query.append("AND    C.COD_RHND_PORT_CD  = L.LOC_CD" ).append("\n"); 
		query.append("AND    L.CONTI_CD          = F.CONTI_CD" ).append("\n"); 
		query.append("AND    F.DELT_FLG          = 'N'" ).append("\n"); 
		query.append("AND    C.OLD_VSL_CD        = V.VSL_CD" ).append("\n"); 
		query.append("AND    C.OLD_SKD_VOY_NO    = V.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    C.OLD_SKD_DIR_CD    = V.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    V.VPS_PORT_CD       = L.LOC_CD" ).append("\n"); 
		query.append("AND    V.VSL_CD            = S.VSL_CD" ).append("\n"); 
		query.append("AND    V.SKD_VOY_NO        = S.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    V.SKD_DIR_CD        = S.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    S.CLPT_SEQ          = S.CLPT_SEQ - 1" ).append("\n"); 
		query.append("AND    S.VPS_PORT_CD       = M.LOC_CD" ).append("\n"); 
		query.append("AND    F.DVS_FEE_TP_CD     = DECODE(SUBSTR(L.CNT_CD,1,2),'US','B',DECODE(L.SCONTI_CD,M.SCONTI_CD,'I',DECODE(SUBSTR(@[tpsz],2,1),2,2,4)))  --:tpsz" ).append("\n"); 
		query.append("AND    G.ACCT_XCH_RT_LVL   = 1" ).append("\n"); 
		query.append("AND    G.CURR_CD           = @[curr_cd]                       --:cur" ).append("\n"); 
		query.append("AND    G.ACCT_XCH_RT_YRMON = TO_CHAR(SYSDATE,'YYYYMM')" ).append("\n"); 
		query.append("AND    F.DVS_FEE_AMT       > (@[rate]/G.USD_LOCL_XCH_RT)   --:rate" ).append("\n"); 

	}
}