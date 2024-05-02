/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BookingARCreationDBDAOAddInvBkgIfFacChgCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.17
*@LastModifier : 
*@LastVersion : 1.0
* 2012.07.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOAddInvBkgIfFacChgCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public BookingARCreationDBDAOAddInvBkgIfFacChgCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOAddInvBkgIfFacChgCSQL").append("\n"); 
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
		query.append("INSERT INTO INV_BKG_IF_CHG" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("BKG_NO ," ).append("\n"); 
		query.append("BKG_SEQ ," ).append("\n"); 
		query.append("CHG_SEQ ," ).append("\n"); 
		query.append("CHG_CD ," ).append("\n"); 
		query.append("CURR_CD ," ).append("\n"); 
		query.append("PER_TP_CD ," ).append("\n"); 
		query.append("TRF_RT_AMT ," ).append("\n"); 
		query.append("RAT_AS_CNTR_QTY ," ).append("\n"); 
		query.append("CHG_AMT ," ).append("\n"); 
		query.append("INV_XCH_RT ," ).append("\n"); 
		query.append("TRF_NO ," ).append("\n"); 
		query.append("OFC_CD ," ).append("\n"); 
		query.append("CUST_CNT_CD ," ).append("\n"); 
		query.append("CUST_SEQ ," ).append("\n"); 
		query.append("IO_BND_CD ," ).append("\n"); 
		query.append("N3RD_FLG ," ).append("\n"); 
		query.append("RCV_TERM_CD," ).append("\n"); 
		query.append("DE_TERM_CD," ).append("\n"); 
		query.append("AUTO_RAT_CD," ).append("\n"); 
		query.append("ACT_CNT_CD," ).append("\n"); 
		query.append("ACT_CUST_SEQ," ).append("\n"); 
		query.append("WHF_FLG," ).append("\n"); 
		query.append("CRE_USR_ID ," ).append("\n"); 
		query.append("CRE_DT ," ).append("\n"); 
		query.append("UPD_USR_ID ," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT FAC.BKG_NO," ).append("\n"); 
		query.append("@[bkg_seq]," ).append("\n"); 
		query.append("NVL((SELECT MAX(NVL(CHG_SEQ,0))+1 FROM INV_BKG_IF_CHG" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no] AND BKG_SEQ = @[bkg_seq]),1)," ).append("\n"); 
		query.append("'FAC'," ).append("\n"); 
		query.append("FAC.CURR_CD," ).append("\n"); 
		query.append("'BL'," ).append("\n"); 
		query.append("ROUND(NVL(FAC.CRNT_AMT,0),2)*-1 ," ).append("\n"); 
		query.append("1," ).append("\n"); 
		query.append("ROUND(NVL(FAC.CRNT_AMT,0),2)*-1," ).append("\n"); 
		query.append("0," ).append("\n"); 
		query.append("''," ).append("\n"); 
		query.append("NVL(BKG.OFC_CD,@[ofc_cd])," ).append("\n"); 
		query.append("NVL(BKG.CUST_CNT_CD,@[cust_cnt_cd])," ).append("\n"); 
		query.append("NVL(BKG.CUST_SEQ,@[cust_seq])," ).append("\n"); 
		query.append("'O'," ).append("\n"); 
		query.append("NVL(BKG.N3RD_FLG,'N')," ).append("\n"); 
		query.append("NVL(BKG.RCV_TERM_CD,'')," ).append("\n"); 
		query.append("NVL(BKG.DE_TERM_CD,'')," ).append("\n"); 
		query.append("NVL(BKG.AUTO_RAT_CD,'')," ).append("\n"); 
		query.append("NVL(BKG.ACT_CNT_CD,'')," ).append("\n"); 
		query.append("NVL(BKG.ACT_CUST_SEQ,'')," ).append("\n"); 
		query.append("NVL(BKG.WHF_FLG,'N')," ).append("\n"); 
		query.append("'FAC' CRE_USR_ID ," ).append("\n"); 
		query.append("SYSDATE ," ).append("\n"); 
		query.append("'FAC' UPD_USR_ID ," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append("FROM ACM_FAC_COMM FAC," ).append("\n"); 
		query.append("INV_BKG_IF_CHG BKG" ).append("\n"); 
		query.append("WHERE FAC.BKG_NO = BKG.BKG_NO(+)" ).append("\n"); 
		query.append("AND FAC.SLS_OFC_CD = BKG.OFC_CD(+)" ).append("\n"); 
		query.append("AND BKG.BKG_SEQ(+) = @[bkg_seq]" ).append("\n"); 
		query.append("AND BKG.IO_BND_CD(+)  = 'O'" ).append("\n"); 
		query.append("AND FAC.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND FAC.SLS_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND FAC.FAC_STS_CD != 'CE'" ).append("\n"); 
		query.append("AND FAC.CRE_USR_ID !='UNIT COST'" ).append("\n"); 
		query.append("AND (FAC.BKG_NO, FAC.FAC_SEQ) = (SELECT /*+ INDEX_DESC(ACM_FAC_COMM, XPKACM_FAC_COMM)*/  C.BKG_NO,C.FAC_SEQ" ).append("\n"); 
		query.append("FROM ACM_FAC_COMM C" ).append("\n"); 
		query.append("WHERE C.BKG_NO = FAC.BKG_NO" ).append("\n"); 
		query.append("AND C.FAC_SEQ = FAC.FAC_SEQ AND ROWNUM = 1)" ).append("\n"); 
		query.append("AND NVL(FAC.CRNT_AMT,0) <> 0" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}