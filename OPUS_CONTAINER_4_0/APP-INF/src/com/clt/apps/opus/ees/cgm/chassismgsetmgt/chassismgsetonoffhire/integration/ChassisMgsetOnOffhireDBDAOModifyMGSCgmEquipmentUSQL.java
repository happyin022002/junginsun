/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChassisMgsetOnOffhireDBDAOModifyMGSCgmEquipmentUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.06
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetOnOffhireDBDAOModifyMGSCgmEquipmentUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ChassisMgsetOnOffhireDBDAOModifyMGSCgmEquipmentUSQL(){
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
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration ").append("\n"); 
		query.append("FileName : ChassisMgsetOnOffhireDBDAOModifyMGSCgmEquipmentUSQL").append("\n"); 
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
		query.append("UPDATE CGM_EQUIPMENT A" ).append("\n"); 
		query.append("  SET    (  A.CRNT_LOC_CD,       A.CRNT_YD_CD, " ).append("\n"); 
		query.append("          A.CHSS_MVMT_STS_CD,      A.CHSS_MVMT_DT, A.GATE_IO_CD, A.CHSS_MVMT_DEST_YD_CD " ).append("\n"); 
		query.append("            ) =       " ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("          SELECT /*+ INDEX_DESC(B XPKCGM_MGST_MVMT_HIS) */" ).append("\n"); 
		query.append("                 SUBSTR( B.YD_CD,0,5),       B.YD_CD, " ).append("\n"); 
		query.append("                 B.MVMT_STS_CD,      B.MVMT_DT,    B.GATE_IO_CD, B.DEST_YD_CD" ).append("\n"); 
		query.append("          FROM   CGM_MGST_MVMT_HIS B" ).append("\n"); 
		query.append("          WHERE  B.MGST_NO  = A.EQ_NO" ).append("\n"); 
		query.append("          AND    ROWNUM     = 1" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("         , A.UPD_DT     = sysdate" ).append("\n"); 
		query.append("         , A.UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(" WHERE A.EQ_NO = @[eq_no]" ).append("\n"); 

	}
}