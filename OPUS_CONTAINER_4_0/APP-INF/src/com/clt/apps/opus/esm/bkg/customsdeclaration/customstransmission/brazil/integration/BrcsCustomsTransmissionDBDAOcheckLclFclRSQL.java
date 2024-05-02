/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BrcsCustomsTransmissionDBDAOcheckLclFclRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.06.19 경종윤
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kyoung Jong Yun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BrcsCustomsTransmissionDBDAOcheckLclFclRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * LCL/FCL 여부를 확인한다.
	  * </pre>
	  */
	public BrcsCustomsTransmissionDBDAOcheckLclFclRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT  'X'" ).append("\n"); 
		query.append("FROM  BKG_BOOKING BK" ).append("\n"); 
		query.append(",BKG_CONTAINER   BC" ).append("\n"); 
		query.append(",BKG_CONTAINER   BC2" ).append("\n"); 
		query.append(",BKG_BOOKING    BK2" ).append("\n"); 
		query.append("WHERE  BC.CNTR_NO      =   @[cntr_no]" ).append("\n"); 
		query.append("AND  BC.CNTR_NO      =   BC2.CNTR_NO" ).append("\n"); 
		query.append("AND  BK.BKG_NO       =   BK2.BKG_NO" ).append("\n"); 
		query.append("AND  BK2.BKG_NO      =   BC2.BKG_NO" ).append("\n"); 
		query.append("AND  BK.VSL_CD       =   BK2.VSL_CD" ).append("\n"); 
		query.append("AND  BK.SKD_VOY_NO   =   BK2.SKD_VOY_NO" ).append("\n"); 
		query.append("AND  BK.SKD_DIR_CD   =   BK2.SKD_DIR_CD" ).append("\n"); 
		query.append("AND  (BK.BKG_NO       <>  BK2.BKG_NO)" ).append("\n"); 
		query.append("AND  BK.BKG_STS_CD    <> 'X'" ).append("\n"); 
		query.append("AND  BK2.BL_NO        IS NOT NULL" ).append("\n"); 
		query.append("AND  BK2.VSL_CD       =   SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("AND  BK2.SKD_VOY_NO   =   SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("AND  BK2.SKD_DIR_CD   =   SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.integration").append("\n"); 
		query.append("FileName : BrcsCustomsTransmissionDBDAOcheckLclFclRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}