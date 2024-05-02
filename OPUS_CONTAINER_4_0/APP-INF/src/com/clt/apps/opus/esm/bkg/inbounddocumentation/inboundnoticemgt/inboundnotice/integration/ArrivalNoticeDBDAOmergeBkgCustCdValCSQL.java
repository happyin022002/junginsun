/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ArrivalNoticeDBDAOmergeBkgCustCdValCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ArrivalNoticeDBDAOmergeBkgCustCdValCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_CUST_CD_VAL table 에 MDM_CUSTOMER 정보 입수시 MDM_CUSTOMER 와 MDM_CUST_ADDR 의 정보를 조회하여 
	  * 데이터를 merge
	  * </pre>
	  */
	public ArrivalNoticeDBDAOmergeBkgCustCdValCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nmd_cust_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_lgl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : ArrivalNoticeDBDAOmergeBkgCustCdValCSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_CUST_CD_VAL a" ).append("\n"); 
		query.append(" USING ( select @[cust_cnt_cd] cust_cnt_cd, @[cust_seq] cust_seq from dual ) b" ).append("\n"); 
		query.append(" ON (a.cust_cnt_cd = b.cust_cnt_cd and a.cust_seq = b.cust_seq )" ).append("\n"); 
		query.append(" WHEN MATCHED THEN" ).append("\n"); 
		query.append(" update" ).append("\n"); 
		query.append(" set" ).append("\n"); 
		query.append("    VAL_CUST_NM = BKG_IB_CUST_NM_VAL_FNC(@[cust_cnt_cd], @[cust_lgl_eng_nm])," ).append("\n"); 
		query.append("    VAL_CUST_ADDR = NVL((" ).append("\n"); 
		query.append("							SELECT /*+ INDEX_DESC(ADDR XPKMDM_CUST_ADDR) */" ).append("\n"); 
		query.append("                                       ADDR.BZET_ADDR" ).append("\n"); 
		query.append("                                  FROM MDM_CUST_ADDR ADDR" ).append("\n"); 
		query.append("                                 WHERE ADDR.PRMRY_CHK_FLG = 'Y'" ).append("\n"); 
		query.append("                                   AND ADDR.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                   AND ADDR.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("                                   AND ADDR.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("                                   AND ADDR.ADDR_TP_CD ='1'" ).append("\n"); 
		query.append("                                   AND ROWNUM = 1" ).append("\n"); 
		query.append("					), VAL_CUST_ADDR )," ).append("\n"); 
		query.append("    NMD_CUST_FLG = NVL(@[nmd_cust_flg], NMD_CUST_FLG)," ).append("\n"); 
		query.append("    DELT_FLG = @[delt_flg]," ).append("\n"); 
		query.append("    upd_usr_id  = NVL(@[upd_usr_id], 'SYSTEM')," ).append("\n"); 
		query.append(" 	upd_dt      = sysdate" ).append("\n"); 
		query.append(" WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append(" insert" ).append("\n"); 
		query.append(" (" ).append("\n"); 
		query.append("    CUST_CNT_CD," ).append("\n"); 
		query.append("    CUST_SEQ," ).append("\n"); 
		query.append("    VAL_CUST_NM," ).append("\n"); 
		query.append("    VAL_CUST_ADDR," ).append("\n"); 
		query.append("    NMD_CUST_FLG," ).append("\n"); 
		query.append("    DELT_FLG," ).append("\n"); 
		query.append("    CRE_USR_ID," ).append("\n"); 
		query.append("    CRE_DT," ).append("\n"); 
		query.append("    UPD_USR_ID," ).append("\n"); 
		query.append("    UPD_DT" ).append("\n"); 
		query.append(" )" ).append("\n"); 
		query.append(" values" ).append("\n"); 
		query.append(" (" ).append("\n"); 
		query.append(" 	@[cust_cnt_cd]," ).append("\n"); 
		query.append(" 	@[cust_seq]," ).append("\n"); 
		query.append(" 	BKG_IB_CUST_NM_VAL_FNC(@[cust_cnt_cd], @[cust_lgl_eng_nm])," ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        	SELECT /*+ INDEX_DESC(ADDR XPKMDM_CUST_ADDR) */" ).append("\n"); 
		query.append("			ADDR.BZET_ADDR" ).append("\n"); 
		query.append("		      FROM MDM_CUST_ADDR ADDR" ).append("\n"); 
		query.append("                 WHERE ADDR.PRMRY_CHK_FLG = 'Y'" ).append("\n"); 
		query.append("                   AND ADDR.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                   AND ADDR.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("                   AND ADDR.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("                   AND ADDR.ADDR_TP_CD ='1'" ).append("\n"); 
		query.append("                   AND ROWNUM = 1" ).append("\n"); 
		query.append("	)," ).append("\n"); 
		query.append(" 	NVL(@[nmd_cust_flg], 'N')," ).append("\n"); 
		query.append(" 	@[delt_flg]," ).append("\n"); 
		query.append(" 	NVL(@[cre_usr_id], 'SYSTEM')," ).append("\n"); 
		query.append(" 	SYSDATE," ).append("\n"); 
		query.append(" 	NVL(@[upd_usr_id], 'SYSTEM')," ).append("\n"); 
		query.append(" 	SYSDATE" ).append("\n"); 
		query.append(" )" ).append("\n"); 

	}
}