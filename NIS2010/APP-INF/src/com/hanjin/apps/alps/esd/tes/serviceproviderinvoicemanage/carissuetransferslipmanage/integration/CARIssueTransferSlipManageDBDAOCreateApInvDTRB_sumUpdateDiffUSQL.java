/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CARIssueTransferSlipManageDBDAOCreateApInvDTRB_sumUpdateDiffUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.09
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2009.11.09 박재흥
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

public class CARIssueTransferSlipManageDBDAOCreateApInvDTRB_sumUpdateDiffUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateApInvDTRB_sumUpdateDiff
	  * </pre>
	  */
	public CARIssueTransferSlipManageDBDAOCreateApInvDTRB_sumUpdateDiffUSQL(){
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
		params.put("inv_no2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gap",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration ").append("\n"); 
		query.append("FileName : CARIssueTransferSlipManageDBDAOCreateApInvDTRB_sumUpdateDiffUSQL").append("\n"); 
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
		query.append("UPDATE AP_INV_DTRB" ).append("\n"); 
		query.append("SET    INV_AMT = DECODE(@[curr_cd],'KRW',ROUND(NVL(INV_AMT,0)+NVL(@[gap],0)),'JPY',ROUND(NVL(INV_AMT,0)+NVL(@[gap],0),0),'TWD',ROUND(NVL(INV_AMT,0)+NVL(@[gap],0),0),ROUND(NVL(INV_AMT,0)+NVL(@[gap],0),2))" ).append("\n"); 
		query.append("WHERE  CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("AND    LINE_TP_LU_CD = 'ITEM'" ).append("\n"); 
		query.append("AND    ATTR_CTNT1    = @[inv_no2]" ).append("\n"); 
		query.append("AND    FTU_USE_CTNT1 = @[cost_cd]" ).append("\n"); 
		query.append("AND    NVL(CNTR_TPSZ_CD,'N')  = NVL(@[cntr_tpsz_cd],'N')      --수정(20070723)" ).append("\n"); 
		query.append("AND    (LINE_SEQ, LINE_NO, INV_AMT ) = ( SELECT LINE_SEQ, LINE_NO, MIN(INV_AMT)" ).append("\n"); 
		query.append("FROM   AP_INV_DTRB" ).append("\n"); 
		query.append("WHERE  CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("AND    LINE_TP_LU_CD = 'ITEM'" ).append("\n"); 
		query.append("AND    ATTR_CTNT1    = @[inv_no2]" ).append("\n"); 
		query.append("AND    FTU_USE_CTNT1 = @[cost_cd]" ).append("\n"); 
		query.append("AND    NVL(CNTR_TPSZ_CD,'N')  = NVL(@[cntr_tpsz_cd],'N')       --수정(20070723)" ).append("\n"); 
		query.append("AND    ROWNUM = 1" ).append("\n"); 
		query.append("GROUP BY LINE_SEQ, LINE_NO)" ).append("\n"); 

	}
}