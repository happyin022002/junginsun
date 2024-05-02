/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AvailableOffHireDBDAOAvailableOffHireContainerStatusCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AvailableOffHireDBDAOAvailableOffHireContainerStatusCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 20160920 HongSeongPil 최초생성
	  * </pre>
	  */
	public AvailableOffHireDBDAOAvailableOffHireContainerStatusCSQL(){
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_co_rtn_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("offh_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.integration").append("\n"); 
		query.append("FileName : AvailableOffHireDBDAOAvailableOffHireContainerStatusCSQL").append("\n"); 
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
		query.append("INSERT INTO LSE_AVAL_OFFH" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("       AGMT_CTY_CD" ).append("\n"); 
		query.append("       , AGMT_SEQ" ).append("\n"); 
		query.append("       , OFFH_SEQ" ).append("\n"); 
		query.append("       , CNTR_NO" ).append("\n"); 
		query.append("       , OFFH_YD_CD                                                     -- 05" ).append("\n"); 
		query.append("       , OFFH_DUE_DT" ).append("\n"); 
		query.append("       , VNDR_SEQ" ).append("\n"); 
		query.append("       , LSTM_CD" ).append("\n"); 
		query.append("       , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       , RMN_QTY                                                        -- 10" ).append("\n"); 
		query.append("       , CNTR_FULL_FLG" ).append("\n"); 
		query.append("       , MVMT_STS_CD" ).append("\n"); 
		query.append("       , ONH_DT" ).append("\n"); 
		query.append("       , USD_DYS" ).append("\n"); 
		query.append("       , MNR_COST_AMT                                                   -- 15" ).append("\n"); 
		query.append("       , MTY_RTN_YD_CD" ).append("\n"); 
		query.append("       , LSE_CO_RTN_YD_CD" ).append("\n"); 
		query.append("       , OFFH_STS_CD" ).append("\n"); 
		query.append("       , LSE_CO_RTN_FLG" ).append("\n"); 
		query.append("       , RQST_OFC_CD                                                    -- 20" ).append("\n"); 
		query.append("       , CRE_USR_ID" ).append("\n"); 
		query.append("       , CRE_DT" ).append("\n"); 
		query.append("       , UPD_USR_ID" ).append("\n"); 
		query.append("       , UPD_DT" ).append("\n"); 
		query.append("       , SND_USR_ID" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  m.agmt_cty_cd" ).append("\n"); 
		query.append("      , m.agmt_seq" ).append("\n"); 
		query.append("      , ( SELECT  NVL(MAX(OFFH_SEQ), 0) + 1" ).append("\n"); 
		query.append("        FROM    LSE_AVAL_OFFH" ).append("\n"); 
		query.append("        WHERE   AGMT_CTY_CD = m.agmt_cty_cd" ).append("\n"); 
		query.append("        AND     AGMT_SEQ    = m.agmt_seq )" ).append("\n"); 
		query.append("      , m.cntr_no" ).append("\n"); 
		query.append("      , @[lse_co_rtn_yd_cd]      " ).append("\n"); 
		query.append("      , '20301231' off_hire_due_date       -- 필수" ).append("\n"); 
		query.append("      , m.vndr_seq" ).append("\n"); 
		query.append("      , m.lstm_cd" ).append("\n"); 
		query.append("      , m.cntr_tpsz_cd" ).append("\n"); 
		query.append("      , 0 -- rem_qty                                                     -- 10" ).append("\n"); 
		query.append("      , DECODE(m.full_flg,'F','Y','N') AS FULL_FLG" ).append("\n"); 
		query.append("      , m.cnmv_sts_cd" ).append("\n"); 
		query.append("      , m.onh_dt" ).append("\n"); 
		query.append("      , ROUND(SYSDATE - m.ONH_DT) AS USED_DAYS   -- used_days" ).append("\n"); 
		query.append("      , (SELECT  /*+ USE_NL( S02 S03 ) */" ).append("\n"); 
		query.append("                  MNR_COMMON_PKG.MNR_GET_RPRCOST_FNC('U', m.CNTR_NO)" ).append("\n"); 
		query.append("          FROM    MNR_ORD_DTL   S02" ).append("\n"); 
		query.append("                , MNR_ORD_HDR   S03" ).append("\n"); 
		query.append("          WHERE   1=1" ).append("\n"); 
		query.append("          AND     m.CNTR_NO              = S02.EQ_NO" ).append("\n"); 
		query.append("          AND     S02.MNR_ORD_OFC_CTY_CD = S03.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("          AND     S02.MNR_ORD_SEQ        = S03.MNR_ORD_SEQ" ).append("\n"); 
		query.append("          GROUP BY m.CNTR_NO" ).append("\n"); 
		query.append("          ) AS MNR_COST                                                   -- 15" ).append("\n"); 
		query.append("      , NVL((SELECT NOD_CD " ).append("\n"); 
		query.append("               FROM SCE_COP_HDR         H" ).append("\n"); 
		query.append("                  , SCE_COP_DTL         D" ).append("\n"); 
		query.append("             WHERE   1 = 1" ).append("\n"); 
		query.append("             AND    H.BKG_NO = M.BKG_NO" ).append("\n"); 
		query.append("             AND    H.CNTR_NO = M.CNTR_NO" ).append("\n"); 
		query.append("             AND    H.COP_NO = D.COP_NO" ).append("\n"); 
		query.append("             AND    D.ACT_CD = 'MITYAD'" ).append("\n"); 
		query.append("             AND    H.COP_STS_CD <> 'X'), M.CRNT_YD_CD)  AS mty_rtn_yd_cd" ).append("\n"); 
		query.append("      , ''" ).append("\n"); 
		query.append("      , @[offh_sts_cd]" ).append("\n"); 
		query.append("      , 'N'" ).append("\n"); 
		query.append("      , (SELECT LST_LGIN_OFC_CD FROM COM_USER WHERE USR_ID = @[upd_usr_id]) LOGIN_OFC_CD  -- 20" ).append("\n"); 
		query.append("      , @[upd_usr_id]" ).append("\n"); 
		query.append("      , SYSDATE" ).append("\n"); 
		query.append("      , @[upd_usr_id]" ).append("\n"); 
		query.append("      , SYSDATE" ).append("\n"); 
		query.append("      , @[upd_usr_id]" ).append("\n"); 
		query.append("FROM mst_container m" ).append("\n"); 
		query.append("WHERE cntr_no = @[cntr_no]" ).append("\n"); 

	}
}