/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SCContractPartyProposalDBDAOCstPriSpCtrtPtyProviderCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.04
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.sccontractpartyproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCContractPartyProposalDBDAOCstPriSpCtrtPtyProviderCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * provider contract party insert
	  * </pre>
	  */
	public SCContractPartyProposalDBDAOCstPriSpCtrtPtyProviderCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.sccontractpartyproposal.integration").append("\n"); 
		query.append("FileName : SCContractPartyProposalDBDAOCstPriSpCtrtPtyProviderCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SP_CTRT_PTY (" ).append("\n"); 
		query.append("     PROP_NO" ).append("\n"); 
		query.append(",    AMDT_SEQ" ).append("\n"); 
		query.append(",    PRC_CTRT_PTY_TP_CD" ).append("\n"); 
		query.append(",    CTRT_PTY_NM" ).append("\n"); 
		query.append(",    CTRT_PTY_ADDR" ).append("\n"); 
		query.append(",    CTRT_PTY_SGN_NM" ).append("\n"); 
		query.append(",    CTRT_PTY_SGN_TIT_NM" ).append("\n"); 
		query.append(",    PRC_PROG_STS_CD" ).append("\n"); 
		query.append(",    SRC_INFO_CD" ).append("\n"); 
		query.append(",	 N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append(",    CRE_USR_ID" ).append("\n"); 
		query.append(",    CRE_DT" ).append("\n"); 
		query.append(",    UPD_USR_ID" ).append("\n"); 
		query.append(",    UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("     @[prop_no]" ).append("\n"); 
		query.append(",    @[amdt_seq]" ).append("\n"); 
		query.append(",    'P'" ).append("\n"); 
		query.append(",    COM_ConstantMgr_PKG.COM_getCompanyName_FNC -- Provider 명" ).append("\n"); 
		query.append(",    NVL(OFC_ADDR,'Please Input')" ).append("\n"); 
		query.append(",    DECODE(PTY.CTRT_PTY_SGN_NM, NULL,'Please Input',PTY.CTRT_PTY_SGN_NM)" ).append("\n"); 
		query.append(",    DECODE(PTY.CTRT_PTY_SGN_TIT_NM, NULL,'Please Input',CTRT_PTY_SGN_TIT_NM)" ).append("\n"); 
		query.append(",    'I'" ).append("\n"); 
		query.append(",    'NW'" ).append("\n"); 
		query.append(",	 @[amdt_seq]" ).append("\n"); 
		query.append(",    @[cre_usr_id]" ).append("\n"); 
		query.append(",    sysdate" ).append("\n"); 
		query.append(",    @[upd_usr_id]" ).append("\n"); 
		query.append(",    sysdate" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION ORG" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT PTY.CTRT_PTY_SGN_NM" ).append("\n"); 
		query.append("      ,PTY.CTRT_PTY_SGN_TIT_NM" ).append("\n"); 
		query.append("      ,PROP_OFC_CD" ).append("\n"); 
		query.append("FROM   PRI_SP_MN MN" ).append("\n"); 
		query.append("      ,PRI_SP_CTRT_PTY PTY" ).append("\n"); 
		query.append("WHERE  MN.PROP_NO = PTY.PROP_NO" ).append("\n"); 
		query.append("AND    MN.AMDT_SEQ = PTY.AMDT_SEQ" ).append("\n"); 
		query.append("AND    MN.PROP_STS_CD = 'F'" ).append("\n"); 
		query.append("AND    MN.PROP_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND    PTY.PRC_CTRT_PTY_TP_CD = 'P'" ).append("\n"); 
		query.append("AND    PTY.UPD_DT =" ).append("\n"); 
		query.append("          (SELECT MAX (PTY.UPD_DT)" ).append("\n"); 
		query.append("           FROM   PRI_SP_MN MN" ).append("\n"); 
		query.append("                 ,PRI_SP_CTRT_PTY PTY" ).append("\n"); 
		query.append("           WHERE  MN.PROP_NO = PTY.PROP_NO" ).append("\n"); 
		query.append("           AND    MN.AMDT_SEQ = PTY.AMDT_SEQ  " ).append("\n"); 
		query.append("		   AND    MN.PROP_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("		   AND    MN.PROP_STS_CD = 'F'" ).append("\n"); 
		query.append("           AND    PTY.PRC_CTRT_PTY_TP_CD = 'P') " ).append("\n"); 
		query.append("AND   ROWNUM = 1" ).append("\n"); 
		query.append(")PTY" ).append("\n"); 
		query.append("WHERE OFC_CD = @[ofc_cd] " ).append("\n"); 
		query.append("AND PROP_OFC_CD (+) = OFC_CD" ).append("\n"); 

	}
}