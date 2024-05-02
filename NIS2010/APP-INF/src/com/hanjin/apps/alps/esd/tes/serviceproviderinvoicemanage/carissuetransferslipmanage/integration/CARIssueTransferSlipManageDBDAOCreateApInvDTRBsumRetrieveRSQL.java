/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CARIssueTransferSlipManageDBDAOCreateApInvDTRBsumRetrieveRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.13
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2009.11.13 박재흥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author park chae heung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CARIssueTransferSlipManageDBDAOCreateApInvDTRBsumRetrieveRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateApInvDTRBsumRetrieve
	  * </pre>
	  */
	public CARIssueTransferSlipManageDBDAOCreateApInvDTRBsumRetrieveRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration ").append("\n"); 
		query.append("FileName : CARIssueTransferSlipManageDBDAOCreateApInvDTRBsumRetrieveRSQL").append("\n"); 
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
		query.append("SELECT ATTR_CTNT1, FTU_USE_CTNT1, CNTR_TPSZ_CD, GAP              									--수정(20070723)" ).append("\n"); 
		query.append("FROM ( SELECT A.ATTR_CTNT1, A.FTU_USE_CTNT1, A.CNTR_TPSZ_CD, NVL(CSR_AMT,0) - NVL(DTRB,0) GAP   	--수정(20070723)" ).append("\n"); 
		query.append("FROM   ( SELECT ATTR_CTNT1, FTU_USE_CTNT1, CNTR_TPSZ_CD, SUM(INV_AMT) DTRB                  --수정(20070723)" ).append("\n"); 
		query.append("FROM   AP_INV_DTRB" ).append("\n"); 
		query.append("WHERE  CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("AND    ATTR_CTNT1 = @[inv_no]" ).append("\n"); 
		query.append("AND    NVL(INV_AMT,0) <> 0" ).append("\n"); 
		query.append("AND    NVL(ATTR_CTNT15,'N') = 'A'        ---- 추가(20071018)" ).append("\n"); 
		query.append("GROUP BY ATTR_CTNT1, FTU_USE_CTNT1, CNTR_TPSZ_CD ) A,      						--수정(20070723)" ).append("\n"); 
		query.append("( SELECT H.INV_NO, D.LGS_COST_CD, D.CNTR_TPSZ_CD, SUM(D.INV_AMT) CSR_AMT             --수정(20070723)" ).append("\n"); 
		query.append("FROM   TES_TML_SO_HDR H, TES_TML_SO_DTL D" ).append("\n"); 
		query.append("WHERE  H.INV_NO              = @[inv_no]" ).append("\n"); 
		query.append("AND    H.VNDR_SEQ            = @[vndr_seq]" ).append("\n"); 
		query.append("AND    H.TML_INV_STS_CD      = 'C'" ).append("\n"); 
		query.append("AND    NVL(H.DELT_FLG,'N')   <> 'Y'" ).append("\n"); 
		query.append("AND    H.TML_SO_OFC_CTY_CD   = D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND    H.TML_SO_SEQ          = D.TML_SO_SEQ" ).append("\n"); 
		query.append("AND    NVL(D.INV_AMT,0)      <> 0" ).append("\n"); 
		query.append("AND    D.CALC_COST_GRP_CD    <> 'SP'" ).append("\n"); 
		query.append("AND    D.CALC_TP_CD          = 'A'" ).append("\n"); 
		query.append("GROUP BY H.INV_NO, D.LGS_COST_CD, D.CNTR_TPSZ_CD ) S                              --수정(20070723)" ).append("\n"); 
		query.append("WHERE A.ATTR_CTNT1 = S.INV_NO" ).append("\n"); 
		query.append("AND   A.FTU_USE_CTNT1 = S.LGS_COST_CD" ).append("\n"); 
		query.append("AND   NVL(A.CNTR_TPSZ_CD,'N') = NVL(S.CNTR_TPSZ_CD,'N') )                                  --수정(20070723)" ).append("\n"); 
		query.append("WHERE NVL(GAP,0) <> 0" ).append("\n"); 

	}
}