/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionEQInvalidReasonDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.08
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2013.07.08 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ISD1
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionEQInvalidReasonDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PreRestrictionEQInvalidReasonDetail
	  * </pre>
	  */
	public PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionEQInvalidReasonDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcgo_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("net_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("out_imdg_pck_qty1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grs_capa_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_imdg_pck_qty1",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionEQInvalidReasonDetailRSQL").append("\n"); 
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
		query.append("SELECT SEQ" ).append("\n"); 
		query.append("      ,INVLD_DESC" ).append("\n"); 
		query.append("  FROM(" ).append("\n"); 
		query.append("		SELECT ROWNUM SEQ" ).append("\n"); 
		query.append("#if(${in_imdg_pck_qty1} != '' || ${in_imdg_pck_cd1} != '')" ).append("\n"); 
		query.append("		      ,CASE WHEN @[dcgo_sts_cd] = 'S' THEN" ).append("\n"); 
		query.append("	#if(${net_wgt} != '')" ).append("\n"); 
		query.append("		          CASE WHEN E.MAX_OUTR_PCK_QTY < TO_NUMBER(@[net_wgt])/TO_NUMBER(@[out_imdg_pck_qty1])*1000 " ).append("\n"); 
		query.append("        		      THEN 'Net weight per outer package ['||ROUND(TO_NUMBER(@[net_wgt])/TO_NUMBER(@[out_imdg_pck_qty1])*1000, 2)||' G] exceeds the weight limit ['||S.IMDG_EXPT_QTY_CD||'('||E.MAX_OUTR_PCK_QTY||' G]] of IMDG regulation. It cannot be more than ['||S.IMDG_EXPT_QTY_CD||'('||E.MAX_OUTR_PCK_QTY||' G)] for UN No-['||@[imdg_un_no]||'].'" ).append("\n"); 
		query.append("                      WHEN E.MAX_INR_PCK_QTY < TO_NUMBER(@[net_wgt])/TO_NUMBER(@[in_imdg_pck_qty1])*1000" ).append("\n"); 
		query.append("		              THEN 'Net weight per inner package ['||ROUND(TO_NUMBER(@[net_wgt])/TO_NUMBER(@[in_imdg_pck_qty1])*1000, 2)||' G] exceeds the weight limit ['||S.IMDG_EXPT_QTY_CD||'('||E.MAX_INR_PCK_QTY||' G)] of IMDG regulation for excepted quantity. It cannot be more than ['||S.IMDG_EXPT_QTY_CD||'('||E.MAX_INR_PCK_QTY||' G)] for UN No-['||@[imdg_un_no]||'].'" ).append("\n"); 
		query.append("		          END" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("                 'Net weight is missing. This UN No- ['||@[imdg_un_no]||'] must have Net Weight.'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("			   ELSE" ).append("\n"); 
		query.append("	#if(${grs_capa_qty} != '')" ).append("\n"); 
		query.append("		          CASE WHEN E.MAX_OUTR_PCK_QTY < TO_NUMBER(@[grs_capa_qty])/TO_NUMBER(@[out_imdg_pck_qty1])*1000 " ).append("\n"); 
		query.append("		               THEN 'Net weight per outer package ['||ROUND(TO_NUMBER(@[grs_capa_qty])/TO_NUMBER(@[out_imdg_pck_qty1])*1000, 2)||' G] exceeds the capacity limit ['||S.IMDG_EXPT_QTY_CD||'('||E.MAX_OUTR_PCK_QTY||' G)] of IMDG regulation for limited quantity. It cannot be more than ['||S.IMDG_EXPT_QTY_CD||'('||E.MAX_OUTR_PCK_QTY||' G)] for UN No-['||@[imdg_un_no]||'].' " ).append("\n"); 
		query.append("		               WHEN E.MAX_INR_PCK_QTY < TO_NUMBER(@[grs_capa_qty])/TO_NUMBER(@[in_imdg_pck_qty1])*1000" ).append("\n"); 
		query.append("		               THEN 'Net weight per inner package ['||ROUND(TO_NUMBER(@[grs_capa_qty])/TO_NUMBER(@[in_imdg_pck_qty1])*1000, 2)||' G] exceeds the capacity limit ['||S.IMDG_EXPT_QTY_CD||'('||E.MAX_INR_PCK_QTY||' G)] of IMDG regulation for excepted quantity. It cannot be more than ['||S.IMDG_EXPT_QTY_CD||'('||E.MAX_INR_PCK_QTY||' G)] for UN No-['||@[imdg_un_no]||'].'  " ).append("\n"); 
		query.append("		          END	" ).append("\n"); 
		query.append("	#elseif(${net_wgt} != '')" ).append("\n"); 
		query.append("		         CASE WHEN E.MAX_OUTR_PCK_QTY < TO_NUMBER(@[net_wgt])/TO_NUMBER(@[out_imdg_pck_qty1])*1000 " ).append("\n"); 
		query.append("        		      THEN 'Net weight per outer package ['||ROUND(TO_NUMBER(@[net_wgt])/TO_NUMBER(@[out_imdg_pck_qty1])*1000, 2)||' G] exceeds the weight limit ['||S.IMDG_EXPT_QTY_CD||'('||E.MAX_OUTR_PCK_QTY||' G)] of IMDG regulation. It cannot be more than ['||S.IMDG_EXPT_QTY_CD||'('||E.MAX_OUTR_PCK_QTY||'g)] for UN No-['||@[imdg_un_no]||'].'" ).append("\n"); 
		query.append("		              WHEN E.MAX_INR_PCK_QTY < TO_NUMBER(@[net_wgt])/TO_NUMBER(@[in_imdg_pck_qty1])*1000" ).append("\n"); 
		query.append("		              THEN 'Net weight per inner package ['||ROUND(TO_NUMBER(@[net_wgt])/TO_NUMBER(@[in_imdg_pck_qty1])*1000, 2)||' G] exceeds the weight limit ['||S.IMDG_EXPT_QTY_CD||'('||E.MAX_INR_PCK_QTY||' G)] of IMDG regulation for excepted quantity. It cannot be more than ['||S.IMDG_EXPT_QTY_CD||'('||E.MAX_INR_PCK_QTY||' G)] for UN No-['||@[imdg_un_no]||'].'" ).append("\n"); 
		query.append("		         END" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("				 'This UN No- ['||@[imdg_un_no]||'] must have either Net Weight or Total Capacity.'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		       END INVLD_DESC" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("              ,'This UN No- ['||@[imdg_un_no]||'] must have both Inner PKG Qty(Pakagings Quantity) and Code.' INVLD_DESC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		  FROM SCG_IMDG_UN_NO S" ).append("\n"); 
		query.append("		      ,SCG_IMDG_EXPT_QTY E" ).append("\n"); 
		query.append("		 WHERE S.IMDG_UN_NO = @[imdg_un_no]" ).append("\n"); 
		query.append("		   AND S.IMDG_UN_NO_SEQ = @[imdg_un_no_seq]" ).append("\n"); 
		query.append("		   AND S.IMDG_EXPT_QTY_CD = E.IMDG_EXPT_QTY_CD" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append(" WHERE INVLD_DESC IS NOT NULL" ).append("\n"); 

	}
}