/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceEdiHitDBDAOSaveInvEdiRcvEqCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.08
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.07.08 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG-IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceEdiHitDBDAOSaveInvEdiRcvEqCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice별 컨테이너(S/O) 저장(TRS_INV_EDI_RCV_EQ 테이블)
	  * </pre>
	  */
	public InvoiceEdiHitDBDAOSaveInvEdiRcvEqCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_msg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trsp_wo_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_edi_rcv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.integration").append("\n"); 
		query.append("FileName : InvoiceEdiHitDBDAOSaveInvEdiRcvEqCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_INV_EDI_RCV_EQ(" ).append("\n"); 
		query.append("	   INV_EDI_RCV_SEQ" ).append("\n"); 
		query.append("	  ,INV_EDI_RCV_SUB_SEQ" ).append("\n"); 
		query.append("	  ,INV_NO" ).append("\n"); 
		query.append("	  ,INV_VNDR_SEQ" ).append("\n"); 
		query.append("	  ,TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("	  ,TRSP_SO_SEQ" ).append("\n"); 
		query.append("	  ,TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("	  ,TRSP_WO_SEQ" ).append("\n"); 
		query.append("	  ,CGO_TP_CD" ).append("\n"); 
		query.append("	  ,TRSP_BND_CD" ).append("\n"); 
		query.append("	  ,EQ_TPSZ_CD" ).append("\n"); 
		query.append("	  ,EQ_NO" ).append("\n"); 
		query.append("	  ,VAL_CHK_FLG" ).append("\n"); 
		query.append("	  ,EDI_MSG" ).append("\n"); 
		query.append("	  ,CRE_USR_ID" ).append("\n"); 
		query.append("	  ,CRE_DT" ).append("\n"); 
		query.append("	  ,UPD_USR_ID" ).append("\n"); 
		query.append("	  ,UPD_DT" ).append("\n"); 
		query.append("  )VALUES(" ).append("\n"); 
		query.append("	   @[inv_edi_rcv_seq]" ).append("\n"); 
		query.append("      ,(SELECT CASE WHEN MAX(INV_EDI_RCV_SUB_SEQ) IS NULL THEN 1" ).append("\n"); 
		query.append("                     ELSE MAX(INV_EDI_RCV_SUB_SEQ)+1 " ).append("\n"); 
		query.append("                END" ).append("\n"); 
		query.append("          FROM TRS_INV_EDI_RCV_EQ" ).append("\n"); 
		query.append("        WHERE INV_EDI_RCV_SEQ = @[inv_edi_rcv_seq])" ).append("\n"); 
		query.append("      ,@[inv_no]" ).append("\n"); 
		query.append("      ,@[inv_vndr_seq]" ).append("\n"); 
		query.append("      ,@[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("      ,@[trsp_so_seq]" ).append("\n"); 
		query.append("      ,@[trsp_wo_ofc_cty_cd]" ).append("\n"); 
		query.append("      ,@[trsp_wo_seq]" ).append("\n"); 
		query.append("      ,@[cgo_tp_cd]" ).append("\n"); 
		query.append("      ,@[trsp_bnd_cd]" ).append("\n"); 
		query.append("      ,SUBSTR(@[eq_tpsz_cd],1,1000)" ).append("\n"); 
		query.append("      ,@[eq_no]" ).append("\n"); 
		query.append("      ,'N' --VAL_CHK_FLG" ).append("\n"); 
		query.append("      ,@[edi_msg]" ).append("\n"); 
		query.append("      ,'HIT_INV_EDI' --CRE_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE  --CRE_DT" ).append("\n"); 
		query.append("      ,'HIT_INV_EDI' --UPD_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE  --UPD_DT" ).append("\n"); 
		query.append("  )" ).append("\n"); 

	}
}