/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMgsetOnOffhireDBDAOmodifyCHSCgmEquipMgSetUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.28
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.10.28 장준우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Jun-Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetOnOffhireDBDAOmodifyCHSCgmEquipMgSetUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Movement 에 의해 Eq Master 정보를 수정한다.개별 M.G.Set의 Master Data Update
	  * </pre>
	  */
	public ChassisMgsetOnOffhireDBDAOmodifyCHSCgmEquipMgSetUSQL(){
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
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration").append("\n"); 
		query.append("FileName : ChassisMgsetOnOffhireDBDAOmodifyCHSCgmEquipMgSetUSQL").append("\n"); 
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
		query.append("UPDATE  CGM_EQUIPMENT A" ).append("\n"); 
		query.append("SET    (A.CRNT_LOC_CD,       " ).append("\n"); 
		query.append("        A.CRNT_YD_CD, " ).append("\n"); 
		query.append("        A.CHSS_MVMT_STS_CD,      " ).append("\n"); 
		query.append("        A.CHSS_MVMT_DT, " ).append("\n"); 
		query.append("        A.GATE_IO_CD, " ).append("\n"); 
		query.append("        A.CHSS_MVMT_DEST_YD_CD) =       " ).append("\n"); 
		query.append("       (SELECT  /*+ INDEX_DESC(B XPKCGM_CHSS_MVMT_HIS) */" ).append("\n"); 
		query.append("                SUBSTR(B.YD_CD, 0,5),       " ).append("\n"); 
		query.append("                B.YD_CD, " ).append("\n"); 
		query.append("                B.MVMT_STS_CD,      " ).append("\n"); 
		query.append("                B.MVMT_DT,    " ).append("\n"); 
		query.append("                B.GATE_IO_CD, " ).append("\n"); 
		query.append("                B.DEST_YD_CD" ).append("\n"); 
		query.append("        FROM    CGM_CHSS_MVMT_HIS B" ).append("\n"); 
		query.append("        WHERE   B.CHSS_NO  = @[eq_no]    " ).append("\n"); 
		query.append("        AND     ROWNUM     = 1             " ).append("\n"); 
		query.append("        )," ).append("\n"); 
		query.append("        A.UPD_DT     = sysdate," ).append("\n"); 
		query.append("        A.UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("WHERE   A.EQ_NO = (SELECT  NVL(A.MGST_NO, (SELECT  /*+ INDEX_DESC(A XPKCGM_EQ_ATCH_DTCH_HIS) */" ).append("\n"); 
		query.append("                                                   B.EQ_NO" ).append("\n"); 
		query.append("                                           FROM    CGM_EQ_ATCH_DTCH_HIS B" ).append("\n"); 
		query.append("                                           WHERE   B.CHSS_NO = A.CHSS_NO" ).append("\n"); 
		query.append("                                           AND     B.EQ_KND_CD = 'G'" ).append("\n"); 
		query.append("                                           AND     B.DTCH_YD_CD IS NULL     " ).append("\n"); 
		query.append("                                           AND     ROWNUM = 1)" ).append("\n"); 
		query.append("                           ) AS MGST_NO" ).append("\n"); 
		query.append("                   FROM   (SELECT  /*+ INDEX_DESC(C XPKCGM_CHSS_MVMT_HIS) */" ).append("\n"); 
		query.append("                                   C.CHSS_NO, C.MGST_NO, C.MVMT_DT, C.SYS_SEQ, C.YD_CD         " ).append("\n"); 
		query.append("                           FROM    CGM_CHSS_MVMT_HIS C" ).append("\n"); 
		query.append("                           WHERE   CHSS_NO = @[eq_no]  " ).append("\n"); 
		query.append("                           AND     ROWNUM = 1) A" ).append("\n"); 
		query.append("                   )" ).append("\n"); 

	}
}